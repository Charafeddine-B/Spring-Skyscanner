package com.flight.scanner.Managment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Plane {
    @Id
    @GeneratedValue
    private Long aircraftId;
    private String manufacturer;
    private String model;
    private Integer numberOfSeats;
}
