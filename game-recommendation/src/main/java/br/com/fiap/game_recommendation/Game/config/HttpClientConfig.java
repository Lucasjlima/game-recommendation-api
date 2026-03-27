package br.com.fiap.game_recommendation.Game.config;

import br.com.fiap.game_recommendation.Game.services.RawgService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration
@ImportHttpServices(types = {RawgService.class})
public class HttpClientConfig {
}
