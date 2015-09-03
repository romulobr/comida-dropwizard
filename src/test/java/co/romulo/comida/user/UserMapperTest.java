package co.romulo.comida.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.skife.jdbi.v2.StatementContext;

import java.sql.ResultSet;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserMapperTest {

    public static final Long ID = 5L;
    public static final String NAME = "the_user_name";
    public static final String PASSWORD = "encrypted_stuff";

    UserMapper mapper;

    @Mock
    private StatementContext statementContext;

    @Mock
    private ResultSet resultSet;

    @Before
    public void setUp() throws Exception {
        mapper = new UserMapper();
    }

    @Test
    public void mapsToUser() throws Exception {

        when(resultSet.getLong("id")).thenReturn(ID);
        when(resultSet.getString("name")).thenReturn(NAME);
        when(resultSet.getString("encrypted_password")).thenReturn(PASSWORD);

        User user = mapper.map(1, resultSet, statementContext);

        assertThat(user.getId(), is(ID));
        assertThat(user.getUsername(), is(NAME));
        assertThat(user.getEncryptedPassword(), is(PASSWORD));
    }
}