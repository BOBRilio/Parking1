package com.parking.backend.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "parking_spots")
public class ParkingSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String number;

    @Column(nullable = false)
    private boolean occupied;

    @OneToMany(mappedBy = "spot", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    // Constructors
    public ParkingSpot() {}

    public ParkingSpot(String number, boolean occupied) {
        this.number = number;
        this.occupied = occupied;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public boolean isOccupied() { return occupied; }
    public void setOccupied(boolean occupied) { this.occupied = occupied; }

    public List<Booking> getBookings() { return bookings; }
    public void setBookings(List<Booking> bookings) { this.bookings = bookings; }
}
