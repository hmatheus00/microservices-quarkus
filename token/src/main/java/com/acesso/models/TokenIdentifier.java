package com.acesso.models;

public class TokenIdentifier {
    private final String identifier;
    private final String tokenType;
    private final Long tokenNumber;
    private final String appServerKey;

    public TokenIdentifier(String identifier, String tokenType, Long tokenNumber, String appServerKey) {
        this.identifier = identifier;
        this.tokenType = tokenType;
        this.tokenNumber = tokenNumber;
        this.appServerKey = appServerKey == null ? "_" : appServerKey ;
    }

    public String toRedisKey() {
        return String.format("dev:%s:%s:%s:%s", identifier, tokenType, tokenNumber, appServerKey);
    }
}
