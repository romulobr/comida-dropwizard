package co.romulo.comida.app;

import co.romulo.comida.auth.SimpleAuthenticator;
import co.romulo.comida.auth.crypto.PasswordCryptographer;
import co.romulo.comida.group.GroupDao;
import co.romulo.comida.group.GroupStore;
import co.romulo.comida.restaurant.RestaurantDao;
import co.romulo.comida.restaurant.RestaurantResource;
import co.romulo.comida.restaurant.RestaurantStore;
import co.romulo.comida.user.User;
import co.romulo.comida.user.UserDao;
import co.romulo.comida.user.UserResource;
import co.romulo.comida.user.UserStore;
import com.codahale.metrics.health.HealthCheck;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.auth.AuthFactory;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicAuthFactory;
import io.dropwizard.auth.basic.BasicCredentials;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.skife.jdbi.v2.DBI;

public class ComidaApplication extends Application<ComidaConfiguration> {

    public static void main(String[] args) throws Exception {
        new ComidaApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<ComidaConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<ComidaConfiguration>() {
            public DataSourceFactory getDataSourceFactory(ComidaConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });

        bootstrap.addBundle(new AssetsBundle("/client", "/client", "index.html", "static"));

    }

    @Override
    public void run(ComidaConfiguration configuration, Environment environment) throws Exception {

        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");

        final UserDao userDao = jdbi.onDemand(UserDao.class);
        final UserStore userStore = new UserStore(userDao, PasswordCryptographer.defaultPasswordCryptographer);

        final UserResource userResource = new UserResource(userStore);

        final GroupDao groupDao = jdbi.onDemand(GroupDao.class);
        final GroupStore groupStore = new GroupStore(groupDao);

        final RestaurantDao restaurantDao = jdbi.onDemand(RestaurantDao.class);
        final RestaurantStore restaurantStore = new RestaurantStore(restaurantDao);
        final RestaurantResource restaurantResource = new RestaurantResource(groupStore, restaurantStore);

        environment.jersey().register(userResource);
        environment.jersey().register(restaurantResource);

        HealthCheck healthCheck = new SimpleHealthCheck();
        environment.healthChecks().register("web", healthCheck);

        environment.jersey().getUrlPattern();

        environment.jersey().register(MultiPartFeature.class);

        Authenticator<BasicCredentials, User> authenticator = new SimpleAuthenticator(userStore);
        environment.jersey().register(AuthFactory.binder(new BasicAuthFactory<User>(authenticator,
                "SUPER SECRET STUFF",
                User.class)));
    }
}
