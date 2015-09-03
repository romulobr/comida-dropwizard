package co.romulo.comida.restaurant.item;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantItemMapper implements ResultSetMapper<RestaurantItem> {
    @Override
    public RestaurantItem map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new RestaurantItem(r.getLong("id"),
                r.getLong("restaurant_id"),
                r.getString("name"),
                r.getString("description"),
                new BigDecimal(r.getString("price"))
        );
    }
}
