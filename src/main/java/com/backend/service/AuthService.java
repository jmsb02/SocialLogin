package com.backend.service;

import com.backend.converter.AuthConverter;
import com.backend.domain.User;
import com.backend.web.dto.KakaoDTO;
import com.backend.repository.UserRepository;
import com.backend.util.JwtUtil;
import com.backend.util.KakaoUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final KakaoUtil kakaoUtil;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;


    public User oAuthLogin(String accessCode, HttpServletResponse httpServletResponse) {
        KakaoDTO.OAuthToken oAuthToken = kakaoUtil.requestToken(accessCode);
        KakaoDTO.KakaoProfile kakaoProfile = kakaoUtil.requestProfile(oAuthToken);
        String email = kakaoProfile.getKakao_account().getEmail();

        User user = userRepository.findByEmail(email)
                .orElseGet(() -> createNewUser(kakaoProfile));

        String token = jwtUtil.createAccessToken(user.getEmail(), user.getRole().toString());
        httpServletResponse.setHeader("Authorization", token);

        return user;
    }

    private User createNewUser(KakaoDTO.KakaoProfile kakaoProfile) {
        User newUser = AuthConverter.toUser(
                kakaoProfile.getKakao_account().getEmail(),
                kakaoProfile.getKakao_account().getProfile().getNickname(),
                null,
                passwordEncoder
        );
        return userRepository.save(newUser);
    }
}
