package at.flokei.entity;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import java.time.LocalDate;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn()
    private HotelRoom room;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Booking(LocalDate bookingDate, LocalDate arrivalDate, LocalDate departureDate, HotelRoom room, Customer customer) {
        this.bookingDate = bookingDate;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.room = room;
        this.customer = customer;
    }

    public Booking() {

    }

    //region getter and setter
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    //endregion


    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", bookingDate=" + bookingDate +
                ", arrivalDate=" + arrivalDate +
                ", departureDate=" + departureDate +
                ", room=" + room +
                ", customer=" + customer +
                '}';
    }
}
