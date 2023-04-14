package com.acesso.externalservices.models;

import java.time.LocalDateTime;

public record Permission(String role, LocalDateTime expirationDateTime) {
}
