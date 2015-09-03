package co.romulo.comida.restaurant.item;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(RestaurantItemMapper.class)
public interface RestaurantItemDao {

    @SqlQuery("select * from restaurant_item_ where restaurant_id = :restaurant_id")
    List<RestaurantItem> findByRestaurantId(@Bind("restaurant_id") Long restaurantId);
}
