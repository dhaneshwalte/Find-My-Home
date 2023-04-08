package com.project.group17.auth.Response;

import jdk.jfr.DataAmount;
import lombok.Builder;

@Builder
public class AuthenticationResponse {
    private String token;
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AuthenticationResponse(String token) {
        this.token = token;
    }
}
