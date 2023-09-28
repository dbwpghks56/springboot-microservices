package net.javaguides.apigateway.domain.repository;

import net.javaguides.apigateway.domain.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);

    User save(User user);
}
