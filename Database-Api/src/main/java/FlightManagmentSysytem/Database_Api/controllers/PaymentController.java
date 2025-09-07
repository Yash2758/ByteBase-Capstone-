package FlightManagmentSysytem.Database_Api.controllers;

import FlightManagmentSysytem.Database_Api.models.Payment;
import FlightManagmentSysytem.Database_Api.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/payment")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> getPayment(@PathVariable UUID paymentId) {
        Payment payment = paymentRepository.findById(paymentId).orElse(null);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment savedPayment = paymentRepository.save(payment);
        return new ResponseEntity<>(savedPayment, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment) {
        Payment updatedPayment = paymentRepository.save(payment);
        return new ResponseEntity<>(updatedPayment, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{paymentId}")
    public ResponseEntity<Void> deletePayment(@PathVariable UUID paymentId) {
        paymentRepository.deleteById(paymentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
