package com.backend.handler;

import com.backend.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * OAuth2 인증 성공 시 호출되어 JWT를 생성하고 클라이언트에 반환하는 작업을 담당하는 핸들러 클래스
 */
@Component
public class JwtAuthenticationSuccessHandler  implements AuthenticationSuccessHandler {

    private final JwtUtil jwtUtil;

    public JwtAuthenticationSuccessHandler(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        handleAuthenticationSuccess(request, response, authentication);

        // 인증 이후 필터 체인을 이어서 실행
        chain.doFilter(request, response);

    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        handleAuthenticationSuccess(request, response, authentication);
    }

    private void handleAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

        System.out.println("JWT 핸들러 실행");
        // OAuth2User에서 사용자 정보 추출
        var user = (org.springframework.security.oauth2.core.user.OAuth2User) authentication.getPrincipal();

        // 사용자 이메일 가져오기
        String email = user.getAttribute("email");

        // JWT 생성
        Map<String, Object> claims = new HashMap<>();
        claims.put("name", user.getAttribute("name"));
        claims.put("email", email);

        String jwt = jwtUtil.generateToken(email, claims);

        // JWT를 프론트엔드에 반환
        response.sendRedirect("http://localhost:8081/oauth2/redirect?token=" + jwt);
        System.out.println("response = " + response);

    }
}
