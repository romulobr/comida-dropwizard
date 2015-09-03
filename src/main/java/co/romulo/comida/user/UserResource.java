package co.romulo.comida.user;

import lombok.AllArgsConstructor;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Consumes(MediaType.APPLICATION_JSON)
@AllArgsConstructor
@Path("/users")
public class UserResource {

    UserStore userStore;

    @POST
    public Response add(@Valid User user) {
        userStore.createUser(user);
        return Response.created(UriBuilder.fromResource(UserResource.class).build()).build();
    }
}
