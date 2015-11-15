package co.romulo.comida.restaurant;

import co.romulo.comida.group.GroupStore;
import co.romulo.comida.user.User;
import lombok.AllArgsConstructor;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@AllArgsConstructor
@Path("/restaurants")
public class RestaurantResource {
    private GroupStore groupStore;
    private RestaurantStore restaurantStore;

    @GET
    public Response getRestaurants(@Valid User user, @QueryParam("group-id") Long groupId) {
        if (!groupStore.isUserInGroup(user, groupId)) {
            return Response.serverError().status(Response.Status.UNAUTHORIZED).build();
        }
        return Response.ok(restaurantStore.restaurantsInGroup(groupId)).build();
    }
}
