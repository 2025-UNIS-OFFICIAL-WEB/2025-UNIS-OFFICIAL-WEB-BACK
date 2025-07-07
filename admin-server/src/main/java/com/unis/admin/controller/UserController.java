package com.unis.admin.controller;

import com.unis.admin.config.JwtTokenProvider;
import com.unis.admin.dto.LoginRequest;
import com.unis.admin.dto.TokenResponse;
import com.unis.common.global.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/user")
public class UserController {

    private final JwtTokenProvider jwtTokenProvider;

    @Value("${admin.username}")
    private String adminUsername;

    @Value("${admin.password}")
    private String adminPassword;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest request) {
        if (adminUsername.equals(request.getUsername()) && adminPassword.equals(request.getPassword())) {
            String role = "ROLE_ADMIN";
            String accessToken = jwtTokenProvider.createToken(adminUsername, role);
            String refreshToken = jwtTokenProvider.createToken(adminUsername, role); // 동일 구조로 발급
            return ResponseEntity.ok(ApiResponse.success(new TokenResponse(accessToken, refreshToken)));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body(ApiResponse.error(401, "아이디 또는 비밀번호가 일치하지 않습니다."));
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestHeader("Authorization") String bearerToken) {
        String token = bearerToken.replace("Bearer ", "");

        if (jwtTokenProvider.validateToken(token)) {
            String username = jwtTokenProvider.getUsername(token);
            String role = jwtTokenProvider.getRole(token);

            if (adminUsername.equals(username) && "ROLE_ADMIN".equals(role)) {
                String newAccessToken = jwtTokenProvider.createToken(username, role);
                return ResponseEntity.ok(ApiResponse.success(new TokenResponse(newAccessToken, token)));
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body(ApiResponse.error(401, "유효하지 않은 토큰입니다."));
    }
}
