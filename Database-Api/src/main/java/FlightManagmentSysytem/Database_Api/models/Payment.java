package FlightManagmentSysytem.Database_Api.models;

import FlightManagmentSysytem.Database_Api.enums.PaymentType;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payments")
@Data
public class Payment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID paymentId;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentType paymentType;
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime paymentDate;
    
    @Column(nullable = false)
    private BigDecimal amount;
    
    @ManyToOne
    private Passenger passenger;
    
    @ManyToOne
    private Flight flight;
    
    @OneToOne
    private Booking booking;
    
    private LocalDate createdAt = LocalDate.now();
    
    private LocalDate updatedAt;
    
    // Default constructor
//    public Payment() {
//        this.paymentDate = LocalDateTime.now();
//    }
//
//    // Parameterized constructor
//    public Payment(PaymentType paymentType, BigDecimal amount, Passenger passenger, Flight flight) {
//        this.paymentType = paymentType;
//        this.amount = amount;
//        this.passenger = passenger;
//        this.flight = flight;
//        this.paymentDate = LocalDateTime.now();
//    }
}
