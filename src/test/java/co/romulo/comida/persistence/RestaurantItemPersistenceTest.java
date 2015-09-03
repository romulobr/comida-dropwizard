package co.romulo.comida.persistence;

import co.romulo.comida.persistence.base.PersistenceTest;
import co.romulo.comida.restaurant.item.RestaurantItemDao;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RestaurantItemPersistenceTest extends PersistenceTest {

    private RestaurantItemDao dao;

    @Override
    protected void setUpDataAccessObjects() {
        dao = dbi.onDemand(RestaurantItemDao.class);
    }

    @Test
    public void retrievesRestaurantsItemsByRestaurantId() throws Exception {
        assertThat(dao.findByRestaurantId(1L).size(), is(2));
        assertThat(dao.findByRestaurantId(2L).size(), is(3));
    }
}
