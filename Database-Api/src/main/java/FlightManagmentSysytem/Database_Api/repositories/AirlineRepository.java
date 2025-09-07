package FlightManagmentSysytem.Database_Api.repositories;

import FlightManagmentSysytem.Database_Api.models.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, UUID> {
}
