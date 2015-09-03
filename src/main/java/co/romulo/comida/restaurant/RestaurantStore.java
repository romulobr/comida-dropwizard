package co.romulo.comida.restaurant;

import java.util.List;

public class RestaurantStore {

    RestaurantDao restaurantDao;

    public List<Restaurant> restaurantsInGroup(Long groupId) {
        return restaurantDao.findByGroupId(groupId);
    }
}
