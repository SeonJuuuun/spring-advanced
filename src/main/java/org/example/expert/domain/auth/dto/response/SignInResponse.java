package org.example.expert.domain.auth.dto.response;

import lombok.Getter;

@Getter
public class SignInResponse {

    private final String bearerToken;

    public SignInResponse(String bearerToken) {
        this.bearerToken = bearerToken;
    }
}