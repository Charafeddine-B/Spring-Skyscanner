package com.flight.scanner.Management.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Flight {
    @Id
    @GeneratedValue
    private long id;
    private String flightNumber;
    private String operatingAirlines;
    @ManyToOne
    private Airport departureAirport;
    @ManyToOne
    private Airport destinationAirport;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate arrivalDate;

    private String departureTime;

    private String arrivalTime;
    private double flightCharge;
    @OneToMany(mappedBy = "flight")
    List<Passenger> passengers = new ArrayList<>();
    @ManyToOne
    Plane plane;
    public Plane getAircraft() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

}
