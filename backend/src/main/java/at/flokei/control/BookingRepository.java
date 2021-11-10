package at.flokei.control;

import at.flokei.entity.Booking;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class BookingRepository {
    @Inject
    EntityManager em;

    @Transactional
    public Booking save(Booking booking) {
        return em.merge(booking);
    }
}
