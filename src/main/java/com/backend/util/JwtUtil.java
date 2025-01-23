package com.backend.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.Map;


/**
 * JWT 생성 관련 로직 담당 유틸리티 클래스
 */
public class JwtUtil {

    private final String secretKey;

    private static final long EXPIRATION_TIME = 86400000; // 1일 (밀리초)

    public JwtUtil(String secretKey) {
        this.secretKey =secretKey;

    }

    public String generateToken(String subject, Map<String, Object> claims) {
        Key signingKey = new SecretKeySpec(secretKey.getBytes(), SignatureAlgorithm.HS256.getJcaName());

        return Jwts.builder()
                .setSubject(subject)
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(signingKey, SignatureAlgorithm.HS256) // Key 객체와 함께 서명
                .compact();
    }

    public String createAccessToken(String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1시간 유효
                .signWith(SignatureAlgorithm.HS256, secretKey) // 비밀키 확인
                .compact();
    }
}
