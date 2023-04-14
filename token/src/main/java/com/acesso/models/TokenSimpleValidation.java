package com.acesso.models;

import java.util.Set;

public record TokenSimpleValidation(String identifier, String clientType, String tokenType, Set<Permission> roles,
                                    LoginType loginType) {
}
