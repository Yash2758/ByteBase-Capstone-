package com.FlightManagmentSysytem.Auth_Api.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final String secret = "mySuperSecretKeyForJwtAuthApi123456"; // 256-bit key
    private final Key key = Keys.hmacShaKeyFor(secret.getBytes());
    private final long expiration = 1000 * 60 * 60; // 1 hour

    // Generate token with email, password, role
    public String generateToken(String email, String password, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("password", password)   // store password
                .claim("role", role)          // store role
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Verify token
    public boolean verifyToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            System.err.println("JWT verification failed: " + e.getMessage());
            return false;
        }
    }

    // Decrypt token and return details
    public String decryptToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject() + "|" + claims.get("password") + "|" + claims.get("role");
    }
}
