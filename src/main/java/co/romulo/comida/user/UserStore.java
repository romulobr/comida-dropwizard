package co.romulo.comida.user;

import co.romulo.comida.auth.crypto.PasswordCryptographer;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserStore {

    UserDao dao;
    PasswordCryptographer passwordCryptographer;

    public User getUserBy(long id) {
        return dao.findById(id);
    }

    public void createUser(User user) {
        dao.insert(user.getUsername(), passwordCryptographer.crypt((user.getEncryptedPassword())));
    }

    public User getUserWithName(String username) {
        return dao.findByUsername(username);
    }
}
