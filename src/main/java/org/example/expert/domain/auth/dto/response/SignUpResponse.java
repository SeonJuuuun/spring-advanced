package org.example.expert.domain.auth.dto.response;

import lombok.Getter;

@Getter
public class SignUpResponse {

    private final Long userId;
    private final String email;
    private final String userRole;

    public SignUpResponse(final Long userId, final String email, final String userRole) {
        this.userId = userId;
        this.email = email;
        this.userRole = userRole;
    }
}
