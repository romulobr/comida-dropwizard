package co.romulo.comida.restaurant.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.joda.time.DateTime;

@AllArgsConstructor
@Getter
public class Order {

    @JsonProperty
    Long id;

    @JsonProperty
    Long restaurantId;

    @JsonProperty
    Long groupId;

    @JsonProperty
    DateTime createdAt;

    @JsonProperty
    DateTime closesAt;

    @JsonProperty
    DateTime deliversAt;
}
