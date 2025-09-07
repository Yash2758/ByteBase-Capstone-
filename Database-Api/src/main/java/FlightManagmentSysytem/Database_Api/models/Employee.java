package FlightManagmentSysytem.Database_Api.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data

public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID employeeId;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String company;
    
    @Column(nullable = false)
    private String role;
    
    @Column(nullable = false)
    private String address;
    
    private LocalDate createdAt = LocalDate.now();
    
    private LocalDate updatedAt;
    
    @ManyToOne

    private Airline airline;
    
    // Default constructor

}
