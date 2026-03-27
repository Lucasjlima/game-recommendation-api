package br.com.fiap.game_recommendation.Game.controller;

import br.com.fiap.game_recommendation.Game.models.RecommendationResponse;
import br.com.fiap.game_recommendation.Game.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/games")
public class GameController {
    @Autowired
    GameService service;

//    @GetMapping
//    public RawgResponse getGame(@RequestParam String name) {
//        return service.getGame(name);
//    }

    @GetMapping
    public RecommendationResponse getRecommendation(@RequestParam String name) {
        return service.recommend(name);
    }
}
