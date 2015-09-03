package co.romulo.comida.restaurant.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class RestaurantItem {

    @JsonProperty
    Long id;

    @JsonProperty
    Long restaurantId;

    @JsonProperty
    String  name;

    @JsonProperty
    String  description;

    @JsonProperty
    BigDecimal price;

}
