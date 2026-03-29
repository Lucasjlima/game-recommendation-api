package br.com.fiap.game_recommendation.usergame.dto.response;

import br.com.fiap.game_recommendation.usergame.entity.GameStatus;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record UserGameResponse(
        UUID id,
        UUID gameId,
        String gameName,
        Double rating,
        Long ratingsCount,
        String backgroundImage,
        String released,
        GameStatus status,
        LocalDateTime savedAt
) {
}
