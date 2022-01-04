package at.flokei.boundary;

import at.flokei.control.BookingRepository;
import at.flokei.entity.Booking;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import javax.inject.Inject;
import java.util.List;

@GraphQLApi
public class BookingResource {
    @Inject
    BookingRepository repo;

    @Query("allBookings")
    @Description("Get all bookings")
    public List<Booking> getAllBookings() {
        return repo.getAll();
    }

    @Mutation("addBooking")
    @Description("Add a booking")
    public Booking addBooking(Booking booking) {
        return repo.addBooking(booking);
    }
}