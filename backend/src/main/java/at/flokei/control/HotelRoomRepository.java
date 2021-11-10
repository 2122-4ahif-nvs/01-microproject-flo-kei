package at.flokei.control;

import at.flokei.entity.HotelRoom;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class HotelRoomRepository {
    @Inject
    EntityManager em;

    @Transactional
    public HotelRoom save(HotelRoom hotelRoom) {
        return em.merge(hotelRoom);
    }
}
