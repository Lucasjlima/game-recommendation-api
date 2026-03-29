package br.com.fiap.game_recommendation.Game.services;

import br.com.fiap.game_recommendation.Game.entity.Game;
import br.com.fiap.game_recommendation.Game.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GamePersistenceService {

    private final GameRepository gameRepository;

    @Transactional
    public Game findOrCreate(String externalName, Double rating, Long ratingsCount,
                             String backgroundImage, String released) {
        return gameRepository.findByExternalName(externalName)
                .orElseGet(() -> {
                    Game game = Game.builder()
                            .externalName(externalName)
                            .rating(rating)
                            .ratingsCount(ratingsCount)
                            .backgroundImage(backgroundImage)
                            .released(released)
                            .build();
                    return gameRepository.save(game);
                });
    }
}
