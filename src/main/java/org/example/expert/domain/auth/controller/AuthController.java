package org.example.expert.domain.auth.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.auth.dto.request.SignInRequest;
import org.example.expert.domain.auth.dto.request.SignUpRequest;
import org.example.expert.domain.auth.dto.response.SignInResponse;
import org.example.expert.domain.auth.dto.response.SignUpResponse;
import org.example.expert.domain.auth.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/signup")
    public SignUpResponse signUp(@Valid @RequestBody SignUpRequest signupRequest) {
        return authService.signUp(signupRequest);
    }

    @PostMapping("/auth/signin")
    public SignInResponse signIn(@Valid @RequestBody SignInRequest signinRequest) {
        return authService.signIn(signinRequest);
    }
}
