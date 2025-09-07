package FlightManagmentSysytem.Database_Api.controllers;

import FlightManagmentSysytem.Database_Api.models.Airline;
import FlightManagmentSysytem.Database_Api.repositories.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/airline")
public class AirlineController {

    @Autowired
    private AirlineRepository airlineRepository;

    @GetMapping("/{airlineId}")
    public ResponseEntity<Airline> getAirline(@PathVariable UUID airlineId) {
        Airline airline = airlineRepository.findById(airlineId).orElse(null);
        return new ResponseEntity<>(airline, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Airline> createAirline(@RequestBody Airline airline) {
        Airline savedAirline = airlineRepository.save(airline);
        return new ResponseEntity<>(savedAirline, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Airline> updateAirline(@RequestBody Airline airline) {
        Airline updatedAirline = airlineRepository.save(airline);
        return new ResponseEntity<>(updatedAirline, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{airlineId}")
    public ResponseEntity<Void> deleteAirline(@PathVariable UUID airlineId) {
        airlineRepository.deleteById(airlineId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
