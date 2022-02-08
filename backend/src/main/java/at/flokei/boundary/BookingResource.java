package at.flokei.boundary;

import at.flokei.Greeter;
import at.flokei.boundary.client.BookingService;
import at.flokei.control.BookingRepository;
import at.flokei.entity.Booking;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;

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