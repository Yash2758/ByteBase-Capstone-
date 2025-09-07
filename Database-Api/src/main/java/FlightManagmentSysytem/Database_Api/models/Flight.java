package FlightManagmentSysytem.Database_Api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.PrePersist;

@Entity
@Table(name = "flights")
@Data
public class Flight {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID flightId;
    
    @Column(nullable = false)
    private String flightNumber;
    
    @Column(nullable = false)
    private String source;
    
    @Column(nullable = false)
    private String destination;
    
    @Column(nullable = false)
    private LocalDateTime departureTime;
    
    @Column(nullable = false)
    private LocalDateTime arrivalTime;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FlightManagmentSysytem.Database_Api.enums.FlightType flightType;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FlightManagmentSysytem.Database_Api.enums.FlightStatus flightStatus;
    
    @Column(nullable = false)
    private Integer totalSeats;
    
    @Column(nullable = false)
    private Integer availableSeats;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_id", nullable = false)
    private Airline airline;
    
    private LocalDate createdAt = LocalDate.now();
    
    private LocalDate updatedAt;
    
    // Set default values
//    @PrePersist
//    protected void onCreate() {
//        if (flightStatus == null) {
//            flightStatus = com.tms.db.Database_Api.enums.FlightStatus.SCHEDULED;
//        }
//        if (availableSeats == null && totalSeats != null) {
//            availableSeats = totalSeats;
//        }
//    }
//
//    // Helper method to book seats
//    public boolean bookSeats(int numberOfSeats) {
//        if (availableSeats >= numberOfSeats) {
//            availableSeats -= numberOfSeats;
//            return true;
//        }
//        return false;
//    }
//
//    // Helper method to cancel booking and release seats
//    public void releaseSeats(int numberOfSeats) {
//        availableSeats = Math.min(availableSeats + numberOfSeats, totalSeats);
//    }
}
