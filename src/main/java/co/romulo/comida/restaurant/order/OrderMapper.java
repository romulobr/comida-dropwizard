package co.romulo.comida.restaurant.order;

import org.joda.time.DateTime;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements ResultSetMapper<Order> {
    @Override
    public Order map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Order(r.getLong("id"),
                r.getLong("restaurant_id"),
                r.getLong("group_id"),
                new DateTime(r.getDate("created_at")),
                new DateTime(r.getDate("closes_at")),
                new DateTime(r.getDate("delivers_at"))
        );
    }
}
