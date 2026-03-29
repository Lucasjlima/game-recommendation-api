package br.com.fiap.game_recommendation.usergame.service;

import br.com.fiap.game_recommendation.User.entity.User;
import br.com.fiap.game_recommendation.Game.entity.Game;
import br.com.fiap.game_recommendation.Game.services.GamePersistenceService;
import br.com.fiap.game_recommendation.usergame.entity.GameStatus;
import br.com.fiap.game_recommendation.usergame.entity.UserGame;
import br.com.fiap.game_recommendation.usergame.repository.UserGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserGameService {

    private final UserGameRepository userGameRepository;
    private final GamePersistenceService gamePersistenceService;

    @Transactional
    public UserGame save(User user, String externalName, Double rating, Long ratingsCount,
                         String backgroundImage, String released, GameStatus status) {

        Game game = gamePersistenceService.findOrCreate(externalName, rating, ratingsCount, backgroundImage, released);

        UserGame userGame = UserGame.builder()
                .user(user)
                .game(game)
                .status(status)
                .build();

        return userGameRepository.save(userGame);
    }
}
