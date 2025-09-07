package FlightManagmentSysytem.Database_Api.models;

import FlightManagmentSysytem.Database_Api.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "passengers")
@Data
public class Passenger {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID passengerId;
    
    @Column(nullable = false)
    private String name;
    
    @Column
    private String email;
    
    @Column
    private String phoneNumber;
    
    @Column(nullable = false)
    private String address;
    
    @Column(nullable = false)
    private Integer age;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
    
    @OneToMany
    private Set<Booking> bookings = new HashSet<>();
    
    @OneToMany
    private Set<Payment> payments = new HashSet<>();
    

    private LocalDate createdAt = LocalDate.now();
    

    private LocalDate updatedAt;
    
//    @PreUpdate
//    protected void onUpdate() {
//        this.updatedAt = LocalDate.now();
//    }
//
//    // Helper methods
//    public void addBooking(Booking booking) {
//        bookings.add(booking);
//        booking.setPassenger(this);
//    }
//
//    public void removeBooking(Booking booking) {
//        bookings.remove(booking);
//        booking.setPassenger(null);
//    }
//
//    public void addPayment(Payment payment) {
//        payments.add(payment);
//        payment.setPassenger(this);
//    }
//
//    public void removePayment(Payment payment) {
//        payments.remove(payment);
//        payment.setPassenger(null);
//    }
}
