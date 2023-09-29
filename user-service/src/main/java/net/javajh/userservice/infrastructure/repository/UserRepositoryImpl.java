package net.javajh.userservice.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import net.javajh.userservice.domain.User;
import net.javajh.userservice.domain.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;


    @Override
    public Optional<User> searchUserByUsername(String username) {
        return userJpaRepository.findByUsername(username);
    }

    @Override
    public boolean userAlready(String username) {
        return userJpaRepository.existsByUsername(username);
    }

    @Override
    public User signUp(User user) {
        return userJpaRepository.save(user);
    }

    @Override
    public Optional<User> login(String username, String password) {
        return userJpaRepository.findByUsernameAndPassword(username, password);
    }
}
