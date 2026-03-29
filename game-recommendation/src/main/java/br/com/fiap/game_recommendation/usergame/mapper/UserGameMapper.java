package br.com.fiap.game_recommendation.usergame.mapper;

import br.com.fiap.game_recommendation.usergame.dto.response.UserGameResponse;
import br.com.fiap.game_recommendation.usergame.entity.UserGame;
import org.springframework.stereotype.Component;

@Component
public class UserGameMapper {

    public UserGameResponse toResponse(UserGame userGame) {
        return UserGameResponse.builder()
                .id(userGame.getId())
                .gameId(userGame.getGame().getId())
                .gameName(userGame.getGame().getExternalName())
                .rating(userGame.getGame().getRating())
                .ratingsCount(userGame.getGame().getRatingsCount())
                .backgroundImage(userGame.getGame().getBackgroundImage())
                .released(userGame.getGame().getReleased())
                .status(userGame.getStatus())
                .savedAt(userGame.getSavedAt())
                .build();
    }
}
