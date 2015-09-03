package co.romulo.comida.restaurant;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(RestaurantMapper.class)
public interface RestaurantDao {
    @SqlQuery("select * from restaurant_ where group_id = :group_id")
    List<Restaurant> findByGroupId(@Bind("group_id") Long groupId);

    @SqlQuery("select * from restaurant_ where id = :id")
    Restaurant byId(@Bind("id") Long id);
}
