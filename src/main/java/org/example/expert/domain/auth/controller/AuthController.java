package org.example.expert.domain.auth.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.auth.dto.request.SignInRequest;
import org.example.expert.domain.auth.dto.request.SignUpRequest;
import org.example.expert.domain.auth.dto.response.SignInResponse;
import org.example.expert.domain.auth.dto.response.SignUpResponse;
import org.example.expert.domain.auth.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/signUp")
    public ResponseEntity<SignUpResponse> signUp(@Valid @RequestBody SignUpRequest signupRequest) {
        final SignUpResponse signUpResponse = authService.signUp(signupRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(signUpResponse);
    }

    @PostMapping("/auth/signIn")
    public ResponseEntity<SignInResponse> signIn(@Valid @RequestBody SignInRequest signinRequest) {
        final SignInResponse signInResponse = authService.signIn(signinRequest);
        return ResponseEntity.ok(signInResponse);
    }
}
