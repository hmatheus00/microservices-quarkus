package com.acesso.models;

import java.time.LocalDateTime;

public record Permission(String role, LocalDateTime expirationDateTime) {
}
