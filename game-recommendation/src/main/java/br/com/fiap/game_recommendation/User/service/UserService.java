package br.com.fiap.game_recommendation.User.service;

import br.com.fiap.game_recommendation.User.entity.User;
import br.com.fiap.game_recommendation.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public record RegisterRequest(String username, String password) {}

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return repository.findAll();
    }

    @Transactional
    public User save(User user) {
        if (repository.findByUsername(user.getUsername()).isPresent())
            throw new RuntimeException("Username already exists, try another username");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUsername(user.getUsername());
        return repository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Iniciando load user by name function");
        var user = repository.findByUsername(username);
        log.info("User {} foi encontrado", username);
        return user.orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
