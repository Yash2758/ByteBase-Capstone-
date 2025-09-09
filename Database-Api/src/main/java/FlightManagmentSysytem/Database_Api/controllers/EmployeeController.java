package FlightManagmentSysytem.Database_Api.controllers;

import FlightManagmentSysytem.Database_Api.models.Employee;
import FlightManagmentSysytem.Database_Api.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable UUID employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        employee.setCreatedAt(LocalDate.now());
        Employee savedEmployee = employeeRepository.save(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        if (employee.getEmployeeId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        employee.setUpdatedAt(LocalDate.now());
        Employee updatedEmployee = employeeRepository.save(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable UUID employeeId) {
        employeeRepository.deleteById(employeeId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @GetMapping("/{email}")
    public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable String email){
       Employee employee =  employeeRepository.findEmployeeByEmail(email);
       return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @GetMapping("/{role}")
    public ResponseEntity<Employee> getEmployeeByRole(@PathVariable String role){
        Employee employee =  employeeRepository.findEmployeeByRole(role);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
