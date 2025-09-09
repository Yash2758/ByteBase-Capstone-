package FlightManagmentSysytem.Database_Api.repositories;

import FlightManagmentSysytem.Database_Api.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    Employee findEmployeeByEmail(String email);
    Employee findEmployeeByRole(String role);
}
