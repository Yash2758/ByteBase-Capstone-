package com.FlightManagmentSysytem.Auth_Api.connector;

import com.FlightManagmentSysytem.Auth_Api.models.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DBAPI {

    @Value("${db.api.base.url}")
    private String baseUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    // Get employee by email
    public Employee callGetEmployeeByEmailEndpoint(String emailId) {
        String url = baseUrl + "/employee/email/" + emailId;
        RequestEntity<Void> request = RequestEntity.get(url).build();
        ResponseEntity<Employee> resp = restTemplate.exchange(request, Employee.class);
        return resp.getBody();
    }

    // Get employee by ID
    public Employee callGetEmployeeByIdEndpoint(String id) {
        String url = baseUrl + "/employee/" + id;
        RequestEntity<Void> request = RequestEntity.get(url).build();
        ResponseEntity<Employee> resp = restTemplate.exchange(request, Employee.class);
        return resp.getBody();
    }
}
