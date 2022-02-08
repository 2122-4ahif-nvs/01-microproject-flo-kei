package at.flokei.boundary.client;

import at.flokei.entity.Booking;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Set;
import java.util.concurrent.CompletionStage;

@Path("/bookings")
@RegisterRestClient(baseUri = "/")
public interface BookingService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{path-param}")
    Set<Booking> getByPathParam(@PathParam("path-param") String pathParam);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{path-param}")
    CompletionStage<Set<Booking>> getByPathParamAsync(@PathParam("path-param") String pathParam);
}
