package net.javaguides.apigateway.domain.service;

import lombok.RequiredArgsConstructor;
import net.javaguides.apigateway.common.exception.user.UserNotFoundException;
import net.javaguides.apigateway.domain.User;
import net.javaguides.apigateway.domain.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);

        return user.toUserDetails();
    }
}
