package com.backend.util;

import java.security.SecureRandom;
import java.util.Base64;

public class SecretKeyGenerator {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[32]; // 256-bit key
        random.nextBytes(key);
        String secretKey = Base64.getUrlEncoder().withoutPadding().encodeToString(key);
        System.out.println("Secret key 생성 : " + secretKey);
    }
}
