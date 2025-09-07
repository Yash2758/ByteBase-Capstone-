package FlightManagmentSysytem.Database_Api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "airlines")
@Data
public class Airline {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID airlineId;
    
    @Column(nullable = false, unique = true)
    private String airlineName;
    

    private String airlineLogo; // Could store URL or Base64 encoded image
    
    @OneToOne

    private Employee systemAdmin;
    

    @OneToMany
    private Set<Employee> employees = new HashSet<>();
    
    private LocalDate createdAt = LocalDate.now();
    
    private LocalDate updatedAt;
    
    // Default constructor

}
