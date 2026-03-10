package br.com.fiap.game_recommendation.services;


import br.com.fiap.game_recommendation.models.RawgResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(
        url = "https://api.rawg.io/api/games",
        accept = "application/json"
)
public interface RawgService {

    @GetExchange
    RawgResponse getRawg(@RequestParam("key") String apiKey, @RequestParam("search") String name);
}