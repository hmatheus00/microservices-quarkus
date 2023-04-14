package com.acesso.models;

public class TokenSessionCredentials {
    private String token;
    private String appKey;

    public TokenSessionCredentials() {
    }

    public TokenSessionCredentials(String token, String appKey) {
        this.token = token;
        this.appKey = appKey;
    }

    public String getToken() {
        return token;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }
}
