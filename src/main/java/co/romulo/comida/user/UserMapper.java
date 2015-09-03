package co.romulo.comida.user;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements ResultSetMapper<User> {

    public User map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String password = resultSet.getString("encrypted_password");
        return new User(id, name, password);
    }
}
