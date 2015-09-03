package co.romulo.comida.auth;

import co.romulo.comida.user.User;
import co.romulo.comida.user.UserStore;
import com.google.common.base.Optional;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import lombok.AllArgsConstructor;

import static org.apache.commons.codec.digest.DigestUtils.sha256Hex;

@AllArgsConstructor
public class SimpleAuthenticator implements Authenticator<BasicCredentials, User> {

    UserStore userStore;

    public Optional<User> authenticate(BasicCredentials credentials) {
        User user = userStore.getUserWithName(credentials.getUsername());
        if (user != null && sha256Hex(credentials.getPassword()).equalsIgnoreCase(user.getEncryptedPassword())) {

            return Optional.of(user);
        }
        return Optional.absent();
    }
}
