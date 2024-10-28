package org.example.expert.domain.auth.dto.response;

import lombok.Getter;

@Getter
public class SignUpResponse {

    private final String bearerToken;

    public SignUpResponse(String bearerToken) {
        this.bearerToken = bearerToken;
    }
}
