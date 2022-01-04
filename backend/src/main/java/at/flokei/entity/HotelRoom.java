package at.flokei.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "HOTEL_ROOM")
public class HotelRoom {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(value = 1)
    private int roomNumber;
    @Min(value = 1)
    private int maxPeople;
    @Min(value = 5)
    private double pricePerNight;

    //region getter and setter
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    //endregion

    //region constructors
    public HotelRoom() {

    }

    public HotelRoom(int roomNumber, int maxPeople, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.maxPeople = maxPeople;
        this.pricePerNight = pricePerNight;
    }
    //endregion

    @Override
    public String toString() {
        return "HotelRoom{" +
                "id=" + id +
                ", roomNumber=" + roomNumber +
                ", maxPeople=" + maxPeople +
                ", pricePerNight=" + pricePerNight +
                '}';
    }
}
