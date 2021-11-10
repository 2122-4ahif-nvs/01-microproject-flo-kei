package at.flokei.entity;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Booking {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonbDateFormat("yyyy-MM-dd")
    private Date bookingDate;

    @JsonbDateFormat("yyyy-MM-dd")
    private Date arrivalDate;

    @JsonbDateFormat("yyyy-MM-dd")
    private Date departureDate;


    private HotelRoom room;

    public Booking(Date bookingDate, Date arrivalDate, Date departureDate, HotelRoom room) {
        this.bookingDate = bookingDate;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.room = room;
    }

    public Booking() {

    }


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
}
