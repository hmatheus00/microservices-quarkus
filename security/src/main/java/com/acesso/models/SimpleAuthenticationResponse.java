package com.acesso.models;

import java.util.Optional;
import java.util.Set;

public class SimpleAuthenticationResponse {
    private UserInfo client;
    private Optional<String> token;
    private Optional<String> tokenType;
    private Set<String> roles;
    private Optional<String> message;
    private Optional<String> levelValidation;
    private Optional<String> loginType;

    public SimpleAuthenticationResponse() {
    }

    public SimpleAuthenticationResponse(UserInfo client, String token, String tokenType,
                                        Set<String> roles, String message, String levelValidation, String loginType) {
        this.client = client;
        this.token = Optional.ofNullable(token);
        this.tokenType = Optional.ofNullable(tokenType);
        this.roles = roles;
        this.message = Optional.ofNullable(message);
        this.levelValidation = Optional.ofNullable(levelValidation);
        this.loginType = Optional.ofNullable(loginType);
    }


    public UserInfo getClient() {
        return client;
    }

    public void setClient(UserInfo client) {
        this.client = client;
    }

    public Optional<String> getToken() {
        return token;
    }

    public void setToken(Optional<String> token) {
        this.token = token;
    }

    public Optional<String> getTokenType() {
        return tokenType;
    }

    public void setTokenType(Optional<String> tokenType) {
        this.tokenType = tokenType;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Optional<String> getMessage() {
        return message;
    }

    public void setMessage(Optional<String> message) {
        this.message = message;
    }

    public Optional<String> getLevelValidation() {
        return levelValidation;
    }

    public void setLevelValidation(Optional<String> levelValidation) {
        this.levelValidation = levelValidation;
    }

    public Optional<String> getLoginType() {
        return loginType;
    }

    public void setLoginType(Optional<String> loginType) {
        this.loginType = loginType;
    }
}

