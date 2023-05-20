package com.flight.scanner.Management.controller;

import com.flight.scanner.Management.model.Airport;
import com.flight.scanner.Management.model.Flight;
import com.flight.scanner.Management.model.Passenger;
import com.flight.scanner.Management.services.AirportService;
import com.flight.scanner.Management.services.FlightService;
import com.flight.scanner.Management.services.PassengerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    @Autowired
    FlightService flightService;
    @Autowired
    AirportService airportService;
    @Autowired
    PassengerService passengerService;

    @GetMapping("/all")
    public List<Flight> getAllFlights() {

        return flightService.getAllFlights() ;
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<Flight> getFlightById(@PathVariable long flightId) {
        Flight flight = flightService.getFlightById(flightId);
        if (flight != null) {
            return ResponseEntity.ok(flight);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Flight> saveFlight(@Valid @RequestBody Flight flight) {
        Flight savedFlight = flightService.saveFlight(flight);
        return ResponseEntity.ok(savedFlight);
    }

    @PutMapping("/{flightId}")
    public ResponseEntity<Flight> updateFlight(@PathVariable long flightId, @Valid @RequestBody Flight flight) {
        Flight existingFlight = flightService.getFlightById(flightId);
        if (existingFlight != null) {
            flight.setId(flightId);
            Flight updatedFlight = flightService.saveFlight(flight);
            return ResponseEntity.ok(updatedFlight);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{flightId}")
    public ResponseEntity<Void> deleteFlight(@PathVariable long flightId) {
        Flight existingFlight = flightService.getFlightById(flightId);
        if (existingFlight != null) {
            flightService.deleteFlightById(flightId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<String> searchFlights(@RequestParam("departureAirport") int departureAirport,
                                                @RequestParam("destinationAirport") int destinationAirport,
                                                @RequestParam("departureTime") String departureTime) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate deptTime = LocalDate.parse(departureTime, dtf);
        Airport depAirport = airportService.getAirportById(departureAirport);
        Airport destAirport = airportService.getAirportById(destinationAirport);

        if (departureAirport == destinationAirport) {
            return ResponseEntity.badRequest().body("Departure and destination airport can't be the same!");
        }

        List<Flight> flights = flightService.getAllFlightsByAirportAndDepartureTime(depAirport, destAirport, deptTime);
        return ResponseEntity.ok(flights.toString());
    }

    @PostMapping("/book")
    public ResponseEntity<Passenger> bookFlight(@Valid @RequestBody Passenger passenger,
                                                @RequestParam("flightId") long flightId) {
        Flight flight = flightService.getFlightById(flightId);
        if (flight == null) {
            return ResponseEntity.notFound().build();
        }

        passenger.setFlight(flight);
        Passenger savedPassenger = passengerService.savePassenger(passenger);
        return ResponseEntity.ok(savedPassenger);
    }

    @GetMapping("/book/{passengerId}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable long passengerId) {
        Passenger passenger = passengerService.getPassengerById(passengerId);
        if (passenger != null) {
            return ResponseEntity.ok(passenger);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/book/{passengerId}")
    public ResponseEntity<Void> cancelTicket(@PathVariable long passengerId) {
        Passenger existingPassenger = passengerService.getPassengerById(passengerId);
        if (existingPassenger != null) {
            passengerService.deletePassengerById(passengerId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
