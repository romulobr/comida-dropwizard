package co.romulo.comida.restaurant.order;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.skife.jdbi.v2.StatementContext;

import java.sql.Date;
import java.sql.ResultSet;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderMapperTest {

    OrderMapper mapper;

    @Mock
    private StatementContext statementContext;

    @Mock
    private ResultSet resultSet;

    private Long ID = 1L;
    private Long RESTAURANT_ID = 2L;
    private Date CREATED_AT = new Date(new DateTime().getMillis());
    private Date CLOSES_AT = new Date(new DateTime().plus(100L).getMillis());
    private Date DELIVERS_AT = new Date(new DateTime().plus(500).getMillis());


    @Before
    public void setUp() throws Exception {
        mapper = new OrderMapper();
    }

    @Test
    public void mapsToOrder() throws Exception {

        when(resultSet.getLong("id")).thenReturn(ID);
        when(resultSet.getLong("restaurant_id")).thenReturn(RESTAURANT_ID);
        when(resultSet.getDate("created_at")).thenReturn(CREATED_AT);
        when(resultSet.getDate("closes_at")).thenReturn(CLOSES_AT);
        when(resultSet.getDate("delivers_at")).thenReturn(DELIVERS_AT);

        Order order = mapper.map(1, resultSet, statementContext);

        assertThat(order.getId(), is(ID));
        assertThat(order.getRestaurantId(), is(RESTAURANT_ID));
        assertThat(order.getCreatedAt(), is(new DateTime(CREATED_AT)));
        assertThat(order.getClosesAt(), is(new DateTime(CLOSES_AT)));
        assertThat(order.getDeliversAt(), is(new DateTime(DELIVERS_AT)));
    }

}