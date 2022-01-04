package at.flokei.control;

import at.flokei.entity.Booking;
import at.flokei.entity.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class BookingRepository {
    @Inject
    EntityManager em;

    @Transactional
    public Booking save(Booking booking) {
        return em.merge(booking);
    }

    public List<Booking> getAll() {
        var query = em.createQuery("select b from Booking b", Booking.class);
        return query.getResultList();
    }

    @Transactional
    public Booking addBooking(Booking booking) {
        return em.merge(booking);
    }

    public List<Booking> getBookingsOfCustomer(String customerName) {
        var query = em.
                createQuery("select b from Booking b where b.customer.name = :NAME", Booking.class)
                .setParameter("NAME",customerName);
        return query.getResultList();
    }
}
