package com.auth.security.jwt.repository;

import com.auth.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByUsername(String username);

    default User findAllByUsernameOrThrow(String username) {
        return findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("No user found with the name %s.", username)));
    }
}
