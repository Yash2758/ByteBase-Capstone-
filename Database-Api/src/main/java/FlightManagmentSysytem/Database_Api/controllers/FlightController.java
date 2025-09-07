package FlightManagmentSysytem.Database_Api.controllers;

import FlightManagmentSysytem.Database_Api.models.Flight;
import FlightManagmentSysytem.Database_Api.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/flight")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping("/{flightId}")
    public ResponseEntity<Flight> getFlight(@PathVariable UUID flightId) {
        Flight flight = flightRepository.findById(flightId).orElse(null);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        Flight savedFlight = flightRepository.save(flight);
        return new ResponseEntity<>(savedFlight, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Flight> updateFlight(@RequestBody Flight flight) {
        Flight updatedFlight = flightRepository.save(flight);
        return new ResponseEntity<>(updatedFlight, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{flightId}")
    public ResponseEntity<Void> deleteFlight(@PathVariable UUID flightId) {
        flightRepository.deleteById(flightId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
