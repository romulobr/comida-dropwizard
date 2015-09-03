package co.romulo.comida.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static co.romulo.comida.auth.crypto.PasswordCryptographer.defaultPasswordCryptographer;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserStoreTest {

    public static final long USER_ID = 1L;
    public static final String USER_PASSWORD = "password";
    public static final String USERNAME = "username";

    @Mock
    private UserDao dao;
    private UserStore userStore;
    private User daoUser;

    @Before
    public void setUp() throws Exception {
        userStore = new UserStore(dao, defaultPasswordCryptographer);
        daoUser = new User(USER_ID, USERNAME, USER_PASSWORD);
        when(dao.findById(USER_ID)).thenReturn(daoUser);
        when(dao.findByUsername(USERNAME)).thenReturn(daoUser);
    }

    @Test
    public void getsUserById() throws Exception {
        User storeUser = userStore.getUserBy(USER_ID);

        assertThat(storeUser, is(daoUser));

    }

    @Test
    public void getsUserByName() throws Exception {
        User storeUser = userStore.getUserWithName(USERNAME);

        assertThat(storeUser, is(daoUser));

    }

    @Test
    public void createsUserWithEncryptedPassword() throws Exception {
        userStore.createUser(daoUser);

        verify(dao).insert(USERNAME, defaultPasswordCryptographer.crypt(USER_PASSWORD));
    }
}