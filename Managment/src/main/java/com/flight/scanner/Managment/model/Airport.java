package com.flight.scanner.Managment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Airport {
    @Id
    @GeneratedValue
    private int airportId;
    private String airportCode;
    private String airportName;
    private String city;
    private String state;
    private String country;
}
