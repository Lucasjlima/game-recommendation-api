package br.com.fiap.game_recommendation.config;

import br.com.fiap.game_recommendation.services.RawgService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration
@ImportHttpServices(types = {RawgService.class})
public class HttpClientConfig {
}
