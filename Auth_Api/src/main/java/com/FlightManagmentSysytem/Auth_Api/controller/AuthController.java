package com.FlightManagmentSysytem.Auth_Api.controller;

import com.FlightManagmentSysytem.Auth_Api.dto.StatusDto;
import com.FlightManagmentSysytem.Auth_Api.dto.TokenDto;
import com.FlightManagmentSysytem.Auth_Api.dto.UserDetailDto;
import com.FlightManagmentSysytem.Auth_Api.security.JwtUtil;
import com.FlightManagmentSysytem.Auth_Api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/token")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthService authService;

    /**
     * Generate a JWT token for the given user details.
     */
    @PostMapping("/generate")
    public ResponseEntity<String> generateToken(@RequestBody UserDetailDto userDetails) {
        // Example: token format = id:email:role
        String token = jwtUtil.generateToken(
                userDetails.getEmail(),
                userDetails.getPassword(),
                userDetails.getRole()
        );
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    /**
     * Verify and validation  a JWT token and return its payload.
     */
    @GetMapping("/verify")
    public ResponseEntity<StatusDto> verifyToken(@RequestHeader("Authorization") String authorization) {
        String token = authorization.substring(7); // remove "Bearer "
        String details = jwtUtil.decryptToken(token);

        StatusDto statusDto = new StatusDto();
        statusDto.setMessage(details);

        return new ResponseEntity<>(statusDto, HttpStatus.OK);
    }

    /**
     * Verify if a user has access to a specific operation.
     */
    @GetMapping("/verify/operation/access/{operationName}")
    public ResponseEntity<TokenDto> verifyOperationAccess(
            @PathVariable String operationName,
            @RequestHeader("Authorization") String authorization
    ) {
        String token = authorization.substring(7); // remove "Bearer "
        boolean result = authService.isValidAccess(token, operationName);

        TokenDto tokenDto = new TokenDto();
        tokenDto.setValid(result);

        if (!result) {
            return new ResponseEntity<>(tokenDto, HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(tokenDto, HttpStatus.OK);
    }
}
