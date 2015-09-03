package co.romulo.comida.restaurant.order;

import org.joda.time.DateTime;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;
@RegisterMapper(OrderMapper.class)
public interface OrderDao {

    @SqlUpdate("insert into order_ (restaurant_id, created_at, closes_at, delivers_at) values (:restaurant_id, :created_at, :closes_at, :delivers_at)")
    void createOrderWith(
            @Bind("restaurant_id") Long restaurantId,
            @Bind("created_at") DateTime createdAt,
            @Bind("closes_at") DateTime closesAt,
            @Bind("delivers_at") DateTime deliversAt);

    @SqlQuery("select * from order_ inner join restaurant_ on order_.restaurant_id = restaurant_.id where group_id = :group_id")
    List<Order> ordersByGroupId(@Bind("group_id") long groupId);
}
