package com.auth.security.jwt;

import com.auth.model.security.Authority;
import com.auth.model.security.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    private JwtUserFactory() {

    }

    public static JwtUser createUser(User user) {
        return new JwtUser(
          user.getId(),
          user.getUsername(),
          user.getFirstname(),
          user.getLastname(),
          user.getPassword(),
          user.getEmail(),
          mapToGrantedAuthorties(user.getAuthorities()),
          user.getEnabled(),
          user.getLastPasswordResetDate()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorties(List<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
                .collect(Collectors.toList());
    }
}
