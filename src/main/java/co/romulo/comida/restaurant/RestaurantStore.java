package co.romulo.comida.restaurant;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RestaurantStore {

    RestaurantDao restaurantDao;

    public List<Restaurant> restaurantsInGroup(Long groupId) {
        return restaurantDao.findByGroupId(groupId);
    }
}
