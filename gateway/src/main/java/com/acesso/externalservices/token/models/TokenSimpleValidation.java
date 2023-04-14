package com.acesso.externalservices.token.models;

import com.acesso.externalservices.token.models.LoginType;
import com.acesso.externalservices.token.models.Permission;

import java.util.Set;

public record TokenSimpleValidation(String identifier, String clientType, String tokenType, Set<Permission> roles,
                                    LoginType loginType) {
}
