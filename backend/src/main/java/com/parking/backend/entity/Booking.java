package com.parking.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "spot_id", nullable = false)
    private ParkingSpot spot;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

    @Column(nullable = false)
    private boolean paid;

    // Constructors
    public Booking() {}

    public Booking(Car car, ParkingSpot spot, LocalDateTime startTime, boolean paid) {
        this.car = car;
        this.spot = spot;
        this.startTime = startTime;
        this.paid = paid;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Car getCar() { return car; }
    public void setCar(Car car) { this.car = car; }

    public ParkingSpot getSpot() { return spot; }
    public void setSpot(ParkingSpot spot) { this.spot = spot; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public boolean isPaid() { return paid; }
    public void setPaid(boolean paid) { this.paid = paid; }
}
