package co.romulo.comida.persistence;

import co.romulo.comida.persistence.base.PersistenceTest;
import co.romulo.comida.restaurant.RestaurantDao;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RestaurantPersistenceTest extends PersistenceTest {

    private RestaurantDao dao;

    @Override
    protected void setUpDataAccessObjects() {
        dao = dbi.onDemand(RestaurantDao.class);
    }

    @Test
    public void retrievesRestaurantsByGroupId() throws Exception {
        assertThat(dao.findByGroupId(1L).size(), is(3));
        assertThat(dao.findByGroupId(2L).size(), is(1));
    }

    @Test
    public void retrievesRestaurantById() throws Exception {
        assertThat(dao.byId(1L).getId(), is(1L));
    }
}
