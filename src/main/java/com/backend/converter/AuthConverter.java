package com.backend.converter;

import com.backend.domain.User;
import com.backend.web.dto.UserResponseDTO;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthConverter {

    public static User toUser(String email, String name, String password, PasswordEncoder passwordEncoder) {
        return User.builder()
                .email(email)
                .role("ROLE_USER")
                .password(passwordEncoder.encode(password))
                .name(name)
                .build();
    }

    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user) {
        return UserResponseDTO.JoinResultDTO.builder()
                .email(user.getEmail())
                .name(user.getName())
                .token("Bearer <JWT_TOKEN>")
                .build();
    }
}
