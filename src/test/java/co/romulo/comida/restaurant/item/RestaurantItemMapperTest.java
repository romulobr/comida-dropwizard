package co.romulo.comida.restaurant.item;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.skife.jdbi.v2.StatementContext;

import java.math.BigDecimal;
import java.sql.ResultSet;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RestaurantItemMapperTest {
    public static final Long ID = 5L;
    public static final String NAME = "the_user_name";
    public static final String DESCRIPTION = "it's a description";
    public static final String PRICE = "10.50";
    public static final Long RESTAURANT_ID = 2L;

    RestaurantItemMapper mapper;

    @Mock
    private StatementContext statementContext;

    @Mock
    private ResultSet resultSet;

    @Before
    public void setUp() throws Exception {
        mapper = new RestaurantItemMapper();
    }

    @Test
    public void mapsToRestaurantItem() throws Exception {

        when(resultSet.getLong("id")).thenReturn(ID);
        when(resultSet.getLong("restaurant_id")).thenReturn(RESTAURANT_ID);
        when(resultSet.getString("name")).thenReturn(NAME);
        when(resultSet.getString("description")).thenReturn(DESCRIPTION);
        when(resultSet.getString("price")).thenReturn(PRICE);

        RestaurantItem restaurant = mapper.map(1, resultSet, statementContext);

        assertThat(restaurant.getId(), is(ID));
        assertThat(restaurant.getRestaurantId(), is(RESTAURANT_ID));
        assertThat(restaurant.getName(), is(NAME));
        assertThat(restaurant.getDescription(), is(DESCRIPTION));
        assertThat(restaurant.getPrice(), is(new BigDecimal(PRICE)));
    }
}