package org.example.authservice.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.example.authservice.domain.entity.UserEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.accessTokenExpiration}")
    private long accessTokenExpiration;

    @Value("${jwt.refreshTokenExpiration}")
    private long refreshTokenExpiration;

    public String generateAccessToken(UserEntity user) {
        return Jwts.builder()
                .subject(user.getUsername())
                /*.claims(Map.of("roles", user.getRole()))*/
                .issuedAt(new Date())
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .expiration(new Date(System.currentTimeMillis() + accessTokenExpiration))
                .compact();
    }

    public String generateRefreshToken(UserEntity user) {
        return Jwts.builder()
                .subject(user.getUsername())
                .issuedAt(new Date())
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .expiration(new Date(System.currentTimeMillis() + refreshTokenExpiration))
                .compact();
    }

}
