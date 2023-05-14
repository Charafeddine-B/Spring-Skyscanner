package com.flight.scanner.Managment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Passenger {
    @Id
    @GeneratedValue
    private long passengerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String passportNumber;
    private String email;
    private String address;
    @ManyToOne
    private Flight flight;
}
