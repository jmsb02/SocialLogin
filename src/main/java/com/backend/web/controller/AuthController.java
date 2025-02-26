package com.backend.web.controller;

import com.backend.apiPayLoad.exception.BaseResponse;
import com.backend.converter.AuthConverter;
import com.backend.domain.User;
import com.backend.web.dto.UserResponseDTO;
import com.backend.web.dto.UserRequestDTO;
import com.backend.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService; // 의존성 주입

    @GetMapping("login/oauth2/code/kakao")
    public BaseResponse<UserResponseDTO.JoinResultDTO> kakaoLogin(@RequestParam("code") String accessCode, HttpServletResponse httpServletResponse) {
        User user = authService.oAuthLogin(accessCode, httpServletResponse);
        return BaseResponse.onSuccess(AuthConverter.toJoinResultDTO(user));
    }


}