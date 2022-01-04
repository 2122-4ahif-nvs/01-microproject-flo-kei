package at.flokei.boundary;

import at.flokei.Greeter;
import at.flokei.control.BookingRepository;
import at.flokei.entity.Booking;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@GraphQLApi
public class BookingResource {
    @Inject
    BookingRepository repo;

    /*@GrpcClient
    Greeter hello;*/

    @Query("allBookings")
    @Description("Get all bookings")
    public List<Booking> getAllBookings() {
        return repo.getAll();
    }

    @Mutation("addBooking")
    @Description("Add a booking")
    public Booking addBooking(@Valid Booking booking) {
        return repo.addBooking(booking);
    }
}