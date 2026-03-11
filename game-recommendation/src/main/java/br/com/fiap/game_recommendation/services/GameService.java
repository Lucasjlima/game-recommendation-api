package br.com.fiap.game_recommendation.services;

import br.com.fiap.game_recommendation.models.GameResult;
import br.com.fiap.game_recommendation.models.RawgResponse;
import br.com.fiap.game_recommendation.models.RecommendationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class GameService {
    @Value("${rawg.api.key}")
    private String apiKey;

    RawgService rawgService;

    public GameService(RawgService rawgService) {
        this.rawgService = rawgService;
    }

    public RawgResponse getGame(String name) {
        return rawgService.getRawg(apiKey, name);
    }

    public RecommendationResponse recommend(String name) {
        RawgResponse rawgResponse = rawgService.getRawg(apiKey, name);
        GameResult gameResult = rawgResponse.results().getFirst();
        System.out.println("Game Result: " + gameResult);
        String recommendation = getRecommendation(gameResult);
        return new RecommendationResponse(
                gameResult.name(),
                gameResult.rating(),
                gameResult.ratingCounts(),
                gameResult.backgroundImage(),
                recommendation
        );
    }

    private String getRecommendation(GameResult gameResult) {
        if (isHighlyRecommended(gameResult)) return "This game is highly recommended";
        if (isWorthIt(gameResult)) return "This game is worth it";
        return "Go and watch a movie";
    }


    private boolean isHighlyRecommended(GameResult game) {
        LocalDate releaseDate = LocalDate.parse(game.released());
        boolean isCurrent = releaseDate.isAfter(LocalDate.now().minusYears(10));
        return game.rating() >= 4.5  && game.ratingCounts() >= 400 && isCurrent;
    }

    private boolean isWorthIt(GameResult game) {
        LocalDate releaseDate = LocalDate.parse(game.released());
        boolean isOld = releaseDate.isBefore(LocalDate.now().minusYears(10));
        return game.rating() >= 3.5 && game.ratingCounts() >= 300 && isOld;
    }

}
