package net.javajh.userservice.domain.repository;

import net.javajh.userservice.domain.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> searchUserByUsername(String username);

    boolean userAlready(String username);

    User signUp(User user);

    Optional<User> login(String username, String password);
}
