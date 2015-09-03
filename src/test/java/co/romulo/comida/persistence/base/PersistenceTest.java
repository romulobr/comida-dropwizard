package co.romulo.comida.persistence.base;

import com.codahale.metrics.MetricRegistry;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jackson.Jackson;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import liquibase.Contexts;
import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.ext.logging.LiquibaseLogger;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import java.io.FileReader;

public abstract class PersistenceTest {

    protected DBI dbi;

    protected Handle handle;

    protected ScriptRunner scriptRunner;

    private Liquibase liquibase;

    protected abstract void setUpDataAccessObjects();

    @Before
    public void setUpDatabase() throws Exception {

        Environment environment = new Environment("test-env", Jackson.newObjectMapper(), null, new MetricRegistry(), null);
        dbi = new DBIFactory().build(environment, getDataSourceFactory(), "test");
        handle = dbi.open();

        migrateDatabase();

        scriptRunner = new ScriptRunner(handle.getConnection(), true, true);

        String fixtureFilePath = getClass().getSimpleName() + "Data.sql";
        FileReader fileReader = new FileReader(getClass().getClassLoader().getResource(fixtureFilePath).getPath());
        scriptRunner.runScript(fileReader);

        setUpDataAccessObjects();
    }

    @After
    public void tearDown() throws Exception {
        liquibase.dropAll();
        handle.close();
    }

    private void migrateDatabase() throws LiquibaseException {

        liquibase = new Liquibase("migrations.xml", new ClassLoaderResourceAccessor(), new JdbcConnection(handle.getConnection()));

        Logger logger = LogManager.getLogger(LiquibaseLogger.class);
        logger.setLevel(Level.ERROR);

        Contexts contexts = new Contexts();
        contexts.add("test");
        liquibase.update(contexts);
        liquibase.update("");
    }

    protected DataSourceFactory getDataSourceFactory() {
        DataSourceFactory dataSourceFactory = new DataSourceFactory();
        dataSourceFactory.setDriverClass("org.h2.Driver");
        dataSourceFactory.setUrl("jdbc:h2:mem:./comida");
        dataSourceFactory.setUser("sa");
        dataSourceFactory.setPassword("sa");

        return dataSourceFactory;
    }
}
