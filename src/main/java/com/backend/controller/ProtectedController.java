package com.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProtectedController {

    @GetMapping("/protected")
    public String getProtectedResource() {
        // 인증된 사용자만 접근 가능
        return "접근 성공";
    }

    @GetMapping("/")
    public String getFailResource() {
        // 인증된 사용자만 접근 가능
        return "접근 실패";
    }
}