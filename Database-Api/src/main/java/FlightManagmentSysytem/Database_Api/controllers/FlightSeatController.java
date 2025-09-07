package FlightManagmentSysytem.Database_Api.controllers;

import FlightManagmentSysytem.Database_Api.models.FlightSeat;
import FlightManagmentSysytem.Database_Api.repositories.FlightSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/flight-seat")
public class FlightSeatController {

    @Autowired
    private FlightSeatRepository flightSeatRepository;

    @GetMapping("/{flightSeatId}")
    public ResponseEntity<FlightSeat> getFlightSeat(@PathVariable UUID flightSeatId) {
        FlightSeat flightSeat = flightSeatRepository.findById(flightSeatId).orElse(null);
        return new ResponseEntity<>(flightSeat, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<FlightSeat> createFlightSeat(@RequestBody FlightSeat flightSeat) {
        FlightSeat savedFlightSeat = flightSeatRepository.save(flightSeat);
        return new ResponseEntity<>(savedFlightSeat, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<FlightSeat> updateFlightSeat(@RequestBody FlightSeat flightSeat) {
        FlightSeat updatedFlightSeat = flightSeatRepository.save(flightSeat);
        return new ResponseEntity<>(updatedFlightSeat, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{flightSeatId}")
    public ResponseEntity<Void> deleteFlightSeat(@PathVariable UUID flightSeatId) {
        flightSeatRepository.deleteById(flightSeatId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
