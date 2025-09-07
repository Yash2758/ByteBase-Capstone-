package FlightManagmentSysytem.Database_Api.controllers;

import FlightManagmentSysytem.Database_Api.models.Passenger;
import FlightManagmentSysytem.Database_Api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/passenger")
public class PassengerController {

    @Autowired
    private PassengerRepository passengerRepository;

    @GetMapping("/{passengerId}")
    public ResponseEntity<Passenger> getPassenger(@PathVariable UUID passengerId) {
        Passenger passenger = passengerRepository.findById(passengerId).orElse(null);
        return new ResponseEntity<>(passenger, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Passenger> createPassenger(@RequestBody Passenger passenger) {
        Passenger savedPassenger = passengerRepository.save(passenger);
        return new ResponseEntity<>(savedPassenger, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Passenger> updatePassenger(@RequestBody Passenger passenger) {
        Passenger updatedPassenger = passengerRepository.save(passenger);
        return new ResponseEntity<>(updatedPassenger, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{passengerId}")
    public ResponseEntity<Void> deletePassenger(@PathVariable UUID passengerId) {
        passengerRepository.deleteById(passengerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
