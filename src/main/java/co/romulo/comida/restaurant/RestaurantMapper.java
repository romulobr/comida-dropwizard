package co.romulo.comida.restaurant;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantMapper implements ResultSetMapper<Restaurant> {
    public Restaurant map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Restaurant(r.getLong("id"),
                r.getLong("group_id"),
                r.getString("name"),
                r.getString("description"),
                r.getString("image_url"),
                new BigDecimal(r.getString("default_delivery_fee"))
        );
    }
}
