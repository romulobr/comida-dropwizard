package co.romulo.comida.user;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(UserMapper.class)
public interface UserDao {

    @SqlUpdate("insert into user_ (name, encrypted_password) values (:name, :encrypted_password)")
    void insert(@Bind("name") String name, @Bind("encrypted_password") String password);

    @SqlQuery("select id, name, encrypted_password from user_ where id = :id")
    User findById(@Bind("id") long id);

    @SqlQuery("select id, name, encrypted_password from user_ where name = :name")
    User findByUsername(@Bind("name") String name);
}
