package co.romulo.comida.persistence;

import co.romulo.comida.persistence.base.PersistenceTest;
import co.romulo.comida.user.User;
import co.romulo.comida.user.UserDao;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class UserPersistenceTest extends PersistenceTest {

    public static final String USERNAME = "monkey";
    UserDao dao;

    @Override
    protected void setUpDataAccessObjects() {
        dao = dbi.onDemand(UserDao.class);
    }

    @Test
    public void findsUserByName() throws Exception {
        User user = dao.findByUsername(USERNAME);
        assertThat(user.getUsername(), is(USERNAME));
    }

    @Test
    public void findsUserById() throws Exception {
        User user = dao.findById(1);
        assertThat(1L, is(user.getId()));
    }

    @Test
    public void insertUser() throws Exception {
        String userName = "someusername";
        String password = "secret";

        dao.insert(userName, password);
        User user = dao.findByUsername(userName);

        assertThat(userName, is(user.getUsername()));
        assertThat(password, is(user.getEncryptedPassword()));
    }
}
