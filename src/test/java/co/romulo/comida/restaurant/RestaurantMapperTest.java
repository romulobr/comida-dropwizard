package co.romulo.comida.restaurant;

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
public class RestaurantMapperTest {
    public static final Long ID = 5L;
    public static final String NAME = "the_user_name";
    public static final String USER_PASSWORD = "encrypted_stuff";
    public static final String DESCRIPTION = "it's a description";
    public static final String IMAGE_URL = "http://images.com/anImage.png";
    public static final String DEFAULT_DELIVERY_FEE = "10.50";
    public static final Long GROUP_ID = 2L;

    RestaurantMapper mapper;

    @Mock
    private StatementContext statementContext;

    @Mock
    private ResultSet resultSet;

    @Before
    public void setUp() throws Exception {
        mapper = new RestaurantMapper();
    }

    @Test
    public void mapsToRestaurant() throws Exception {

        when(resultSet.getLong("id")).thenReturn(ID);
        when(resultSet.getLong("group_id")).thenReturn(GROUP_ID);
        when(resultSet.getString("name")).thenReturn(NAME);
        when(resultSet.getString("description")).thenReturn(DESCRIPTION);
        when(resultSet.getString("image_url")).thenReturn(IMAGE_URL);
        when(resultSet.getString("default_delivery_fee")).thenReturn(DEFAULT_DELIVERY_FEE);


        Restaurant restaurant = mapper.map(1, resultSet, statementContext);

        assertThat(restaurant.getId(), is(ID));
        assertThat(restaurant.getGroupId(), is(GROUP_ID));
        assertThat(restaurant.getName(), is(NAME));
        assertThat(restaurant.getDescription(), is(DESCRIPTION));
        assertThat(restaurant.getImageUrl(), is(IMAGE_URL));
        assertThat(restaurant.getDefaultDeliveryFee(), is(new BigDecimal(DEFAULT_DELIVERY_FEE)));
    }
}