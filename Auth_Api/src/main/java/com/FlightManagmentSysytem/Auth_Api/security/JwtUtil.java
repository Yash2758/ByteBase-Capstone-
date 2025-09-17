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

    // Generate token with email and password only
    public String generateToken(String email, String password) {
        return Jwts.builder()
                .setSubject(email)
                .claim("password", password)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean verifyToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            System.err.println("JWT verification failed: " + e.getMessage());
            return false;
        }
    }

    public String decryptToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject() + "|" + claims.get("password");
    }
}
