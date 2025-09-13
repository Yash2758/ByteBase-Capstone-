package com.FlightManagmentSysytem.Auth_Api.service;

import com.FlightManagmentSysytem.Auth_Api.connector.DBAPI;
import com.FlightManagmentSysytem.Auth_Api.models.Operation;
import com.FlightManagmentSysytem.Auth_Api.models.Role;
import com.FlightManagmentSysytem.Auth_Api.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    DBAPI dbapi;

    @Autowired
    JwtUtil jwtUtil;

    public boolean isValidAccess(String token, String operationName) {
        // Verify token
        if (!jwtUtil.verifyToken(token)) {
            return false;
        }

        // Extract info → "email:role"
        String information = jwtUtil.decryptToken(token);
        String[] infoArr = information.split(":");
        if (infoArr.length < 2) {
            return false;
        }

        String roleName = infoArr[1]; // role is second

        // Fetch role details from DB
        Role role = dbapi.callGetRoleByNameEndpoint(roleName);
        if (role == null || role.getOperations() == null) {
            return false;
        }

        // Check if operation exists for this role
        for (Operation operation : role.getOperations()) {
            if (operation.getName().equalsIgnoreCase(operationName)) {
                return true;
            }
        }
        return false;
    }
}
