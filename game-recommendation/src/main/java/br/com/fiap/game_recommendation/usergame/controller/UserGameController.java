package br.com.fiap.game_recommendation.usergame.controller;

import br.com.fiap.game_recommendation.User.entity.User;
import br.com.fiap.game_recommendation.User.service.UserService;
import br.com.fiap.game_recommendation.usergame.dto.request.SaveGameRequest;
import br.com.fiap.game_recommendation.usergame.dto.response.UserGameResponse;
import br.com.fiap.game_recommendation.usergame.entity.UserGame;
import br.com.fiap.game_recommendation.usergame.mapper.UserGameMapper;
import br.com.fiap.game_recommendation.usergame.service.UserGameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/me/games")
public class UserGameController {

    private final UserGameService userGameService;
    private final UserGameMapper userGameMapper;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserGameResponse> saveGame(@AuthenticationPrincipal Jwt jwt,
                                                     @RequestBody @Valid SaveGameRequest request) {

        User user = (User) userService.loadUserByUsername(jwt.getSubject());

        UserGame userGame = userGameService.save(
                user,
                request.name(),
                request.rating(),
                request.ratingsCount(),
                request.backgroundImage(),
                request.released(),
                request.status()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(userGameMapper.toResponse(userGame));
    }
}
