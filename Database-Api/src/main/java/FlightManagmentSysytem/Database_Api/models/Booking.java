package FlightManagmentSysytem.Database_Api.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity

@Data
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID bookingId;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FlightManagmentSysytem.Database_Api.enums.BookingStatus bookingStatus;
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime bookingDate;
    
    @OneToOne
    private Payment payment;
    
    private LocalDate createdAt = LocalDate.now();
    
    private LocalDate updatedAt;
    
    @ManyToOne
    private Passenger passenger;
    
    @ManyToOne
    private Flight flight;
    
    // Import the BookingStatus enum from the enums package

    // Set default values

}
