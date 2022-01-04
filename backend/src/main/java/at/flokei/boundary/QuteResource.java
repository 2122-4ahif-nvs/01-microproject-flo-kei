package at.flokei.boundary;

import at.flokei.control.BookingRepository;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("api")
public class QuteResource {
    @Inject
    Template quteTemplate;

    @Inject
    Template quteBookingOverview;

    @Inject
    Template quteBookingTable;

    @Inject
    BookingRepository bookingRepo;

    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getHello(@QueryParam("name") String name) {
        return quteTemplate.data("name", name);
    }

    @GET
    @Path("bookings")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getBookings(@QueryParam("name") String name) {
        var bookings = bookingRepo.getBookingsOfCustomer(name);
        return quteBookingOverview.data("bookings", bookings);
    }

    @GET
    @Path("bookings-formatted")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getFormattedBookings(@QueryParam("name") String name) {
        var bookings = bookingRepo.getBookingsOfCustomer(name);
        return quteBookingTable.data("bookings", bookings);
    }
}
