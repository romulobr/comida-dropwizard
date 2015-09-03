package co.romulo.comida.auth;

import co.romulo.comida.user.User;
import co.romulo.comida.user.UserStore;
import com.google.common.base.Optional;
import io.dropwizard.auth.basic.BasicCredentials;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.apache.commons.codec.digest.DigestUtils.sha256Hex;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SimpleAuthenticatorTest {

    public static final String USERNAME = "admin";
    @Mock
    UserStore userStore;
    private String PLAIN_TEXT_PASSWORD;

    @Test
    public void authenticatesAgainstHashedPassword() throws Exception {
        BasicCredentials credentials = new BasicCredentials("admin", "secret");

        PLAIN_TEXT_PASSWORD = "secret";
        User adminUser = new User(1L, USERNAME, sha256Hex(PLAIN_TEXT_PASSWORD).toUpperCase());
        when(userStore.getUserWithName(USERNAME)).thenReturn(adminUser);

        SimpleAuthenticator simpleAuthenticator = new SimpleAuthenticator(userStore);
        Optional<User> authenticatedPrincipal = simpleAuthenticator.authenticate(credentials);
        assertThat(authenticatedPrincipal.get(), is(adminUser));

    }
}