package at.flokei.boundary;

import at.flokei.boundary.client.BookingService;
import at.flokei.entity.Booking;
import io.quarkus.security.identity.SecurityIdentity;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletionStage;

@Path("")
public class UserResource {
    @Inject
    SecurityIdentity securityIdentity;

    @GET
    @Path("api/usersl")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserInfo() {
        return Response.ok(
                Map.of("username",securityIdentity.getPrincipal().getName())
        ).build();
    }

    @Inject
    @RestClient
    BookingService bookingService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{path-param}")
    public Set<Booking> getByPathParam(@PathParam("path-param") String pathParam) {
        return bookingService.getByPathParam(pathParam);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("async/{path-param}")
    public CompletionStage<Set<Booking>> getByPathParamAsync(@PathParam("path-param") String pathParam) {
        return bookingService.getByPathParamAsync(pathParam);
    }
}
