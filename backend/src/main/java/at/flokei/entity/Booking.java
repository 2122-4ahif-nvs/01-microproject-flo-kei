package at.flokei.entity;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "HOTEL_BOOKING")
public class Booking {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonbDateFormat("yyyy-MM-dd")
    private LocalDate bookingDate;

    @JsonbDateFormat("yyyy-MM-dd")
    private LocalDate arrivalDate;

    @JsonbDateFormat("yyyy-MM-dd")
    private LocalDate departureDate;

    @ManyToOne
    @JoinColumn()
    private HotelRoom room;



    public Booking(LocalDate bookingDate, LocalDate arrivalDate, LocalDate departureDate, HotelRoom room) {
        this.bookingDate = bookingDate;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.room = room;
    }

    public Booking() {

    }

    public HotelRoom getRoom() {
        return room;
    }

    public void setRoom(HotelRoom room) {
        this.room = room;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }
}
