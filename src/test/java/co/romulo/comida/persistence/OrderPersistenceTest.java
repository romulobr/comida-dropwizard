package co.romulo.comida.persistence;

import co.romulo.comida.persistence.base.PersistenceTest;
import co.romulo.comida.restaurant.order.OrderDao;
import org.joda.time.DateTime;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.Statement;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrderPersistenceTest  extends PersistenceTest {

    OrderDao dao;

    @Override
    protected void setUpDataAccessObjects() {
        dao = dbi.onDemand(OrderDao.class);
    }

    @Test
    public void fetchesOrdersByGroupId() throws Exception {
        assertThat(dao.ordersByGroupId(1L).size(),is(4));
        assertThat(dao.ordersByGroupId(2L).size(),is(2));
    }

    @Test
    public void insertsOrder() throws Exception {
        dao.createOrderWith(2L, new DateTime(),new DateTime(),new DateTime());

        Statement statement = handle.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select * from order_ where restaurant_id = 2");
        resultSet.next();
        long id = resultSet.getLong("restaurant_id");
        assertThat(id, is(2L));
    }
}