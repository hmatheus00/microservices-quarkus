package com.acesso.models;

public class SessionCredentials {

    private String token;
    private String appServerKey;

    public SessionCredentials(String token, String appServerKey) {
        this.token = token;
        this.appServerKey = appServerKey;
    }

    public SessionCredentials() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAppServerKey() {
        return appServerKey;
    }

    public void setAppServerKey(String appServerKey) {
        this.appServerKey = appServerKey;
    }
}
