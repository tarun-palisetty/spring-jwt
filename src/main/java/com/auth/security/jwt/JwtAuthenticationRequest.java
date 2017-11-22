package com.auth.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class JwtAuthenticationRequest implements Serializable {
    private static final Long serialVersionUID = 1L;

    private String username;
    private String password;
}
