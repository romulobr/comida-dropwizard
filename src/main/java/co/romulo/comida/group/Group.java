package co.romulo.comida.group;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Group {
    @JsonProperty
    Long id;

    @JsonProperty
    String name;

    @JsonProperty
    String encryptedPassword;

}
