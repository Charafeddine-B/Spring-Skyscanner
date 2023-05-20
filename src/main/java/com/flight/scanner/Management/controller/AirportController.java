package com.flight.scanner.Management.controller;

import com.flight.scanner.Management.model.Airport;
import com.flight.scanner.Management.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    private AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/all")
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("/{airportId}")
    public ResponseEntity<Airport> getAirportById(@PathVariable Integer airportId) {
        Airport  airport = airportService.getAirportById(airportId);
        if(airport == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(airport);
    }

    @PostMapping("/add")
    public Airport addAirport(@RequestBody Airport airport) {

        return airportService.addAirport(airport);
    }

    @PutMapping("/update/{airportId}")
    public Airport updateAirport(@PathVariable Integer airportId, @RequestBody Airport airport) {
        Airport existingAirport = airportService.getAirportById(airportId);
        if (existingAirport != null) {
            airport.setAirportId(airportId);
            return airportService.saveAirport(airport);
        }
        return null;
    }

    @DeleteMapping("/delete/{airportId}")
    public boolean deleteAirport(@PathVariable("airportId") Integer airportId) {
        return airportService.deleteAirport(airportId);
    }
}
