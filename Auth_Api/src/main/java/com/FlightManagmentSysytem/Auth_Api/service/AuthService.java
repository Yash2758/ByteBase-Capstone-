package com.FlightManagmentSysytem.Auth_Api.service;

import com.FlightManagmentSysytem.Auth_Api.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * Check if the token is valid.
     * Since roles/operations are removed, we only verify the token.
     */
    public boolean isValidAccess(String token) {
        return jwtUtil.verifyToken(token);
    }
}
