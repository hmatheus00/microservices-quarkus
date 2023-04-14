package com.acesso.externalservices.token.models;

import java.time.LocalDateTime;

public record Permission(String role, LocalDateTime expirationDateTime) {
}
