package br.com.fiap.game_recommendation.Security.controller;

import br.com.fiap.game_recommendation.Security.services.TokenService;
import br.com.fiap.game_recommendation.User.dto.request.UserRequest;
import br.com.fiap.game_recommendation.User.dto.response.UserResponse;
import br.com.fiap.game_recommendation.User.entity.User;
import br.com.fiap.game_recommendation.User.mapper.UserMapper;
import br.com.fiap.game_recommendation.User.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/")
public class SecurityController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UserService userService;

    public record TokenResponse(String token) {}

    @PostMapping("login")
    public TokenResponse login(@RequestBody UserRequest request) {
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );
        return new TokenResponse(tokenService.generateToken(authentication.getName()));
    }

    @PostMapping("register")
    public ResponseEntity<UserResponse> register(@RequestBody  @Valid UserRequest request) {
        User newUser = UserMapper.toUser(request);
        User savedUser = userService.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(savedUser));
    }

}
