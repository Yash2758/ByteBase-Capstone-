package FlightManagmentSysytem.Database_Api.models;

import FlightManagmentSysytem.Database_Api.enums.SeatStatus;
import FlightManagmentSysytem.Database_Api.enums.SeatClass;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "flight_seats")
@Data
public class FlightSeat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID seatId;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatStatus seatStatus = SeatStatus.AVAILABLE;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatClass seatClass;
    
    @Column(nullable = false)
    private String seatNumber;
    
    @Column(nullable = false)
    private BigDecimal seatAmount;
    
    @ManyToOne
    private Flight flight;
    
    @ManyToOne
    private Booking booking;
    
    private LocalDate createdAt = LocalDate.now();
    
    private LocalDate updatedAt;
    
    // Default constructor

}
