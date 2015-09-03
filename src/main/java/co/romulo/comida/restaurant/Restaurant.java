package co.romulo.comida.restaurant;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class Restaurant {
    @JsonProperty
    Long id;

    @JsonProperty
    Long groupId;

    @JsonProperty
    String name;

    @JsonProperty
    String description;

    @JsonProperty
    String imageUrl;

    @JsonProperty
    BigDecimal defaultDeliveryFee;
}
