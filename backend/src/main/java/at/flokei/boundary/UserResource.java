package at.flokei.boundary;

import io.quarkus.security.identity.SecurityIdentity;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("api/users")
public class UserResource {
    @Inject
    SecurityIdentity securityIdentity;

    @GET
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserInfo() {
        return Response.ok(
                Map.of("username",securityIdentity.getPrincipal().getName())
        ).build();
    }
}
