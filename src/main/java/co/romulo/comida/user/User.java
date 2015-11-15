package co.romulo.comida.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class User {
    @JsonProperty
    Long id;

    @JsonProperty
    String username;

    @JsonProperty
    String encryptedPassword;
}
