package FlightManagmentSysytem.Database_Api.controllers;

import FlightManagmentSysytem.Database_Api.models.Booking;
import FlightManagmentSysytem.Database_Api.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/booking")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBooking(@PathVariable UUID bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking savedBooking = bookingRepository.save(booking);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking) {
        Booking updatedBooking = bookingRepository.save(booking);
        return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{bookingId}")
    public ResponseEntity<Void> deleteBooking(@PathVariable UUID bookingId) {
        bookingRepository.deleteById(bookingId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
