package com.FlightManagmentSysytem.Auth_Api.controller;

import com.FlightManagmentSysytem.Auth_Api.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth/token")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    // Generate token
    @PostMapping("/generate")
    public ResponseEntity<String> generateToken(@RequestBody Map<String, String> userDetails) {
        String email = userDetails.get("email");
        String password = userDetails.get("password");

        String token = jwtUtil.generateToken(email, password);

        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    // Verify token
    @GetMapping("/verify")
    public ResponseEntity<String> verifyToken(@RequestHeader("Authorization") String authorization) {
        String token = authorization.substring(7); // remove "Bearer "
        boolean valid = jwtUtil.verifyToken(token);

        if (!valid) {
            return new ResponseEntity<>("Invalid token", HttpStatus.UNAUTHORIZED);
        }

        String details = jwtUtil.decryptToken(token);
        return new ResponseEntity<>(details, HttpStatus.OK);
    }
}
