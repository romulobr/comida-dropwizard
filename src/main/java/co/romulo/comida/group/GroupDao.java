package co.romulo.comida.group;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(GroupMapper.class)
public interface GroupDao {

    @SqlQuery("select * from group_ inner join user_group_ on group_id = id where user_id = :user_id")
    List<Group> findGroupsOwnedByUserWithId(@Bind("user_id") Long userId);

    @SqlQuery("select group_id from user_group_ where group_id = :group_id and user_id = :user_id")
    Long findUserIdInGroupOrNothing(@Bind("group_id") Long groupId, @Bind("user_id") Long userId);
}
