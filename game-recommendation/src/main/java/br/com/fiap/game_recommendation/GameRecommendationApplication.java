package br.com.fiap.game_recommendation;

import br.com.fiap.game_recommendation.Security.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableConfigurationProperties(RsaKeyProperties.class)
public class GameRecommendationApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameRecommendationApplication.class, args);
	}

}
