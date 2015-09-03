package co.romulo.comida.group;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupMapper implements ResultSetMapper<Group> {
    public Group map(int index, ResultSet resultSet, StatementContext ctx) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String password = resultSet.getString("encrypted_password");
        return new Group(id, name, password);
    }
}
