package com.auth.security.jwt.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class JwtAuthenticationResponse implements Serializable{

    private static final Long serialVersionUID = 1L;

    private final String token;




}
