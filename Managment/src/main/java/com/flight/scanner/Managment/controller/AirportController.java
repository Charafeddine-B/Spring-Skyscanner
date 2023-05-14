package com.flight.scanner.Managment.controller;

import com.flight.scanner.Managment.model.Airport;
import com.flight.scanner.Managment.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class AirportController {
    @Autowired
    AirportService airportService;

//    @GetMapping("/d")
//    public List<Airport> ShowHomePage(){
//        return airportService.getAllAirports();
//    }

    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }
}
