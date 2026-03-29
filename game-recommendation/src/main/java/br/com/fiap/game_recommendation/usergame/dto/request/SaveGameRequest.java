package br.com.fiap.game_recommendation.usergame.dto.request;

import br.com.fiap.game_recommendation.usergame.entity.GameStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SaveGameRequest(
        @NotBlank(message = "Game name is required")
        String name,

        @NotNull(message = "Rating is required")
        Double rating,

        Long ratingsCount,

        String backgroundImage,

        String released,

        @NotNull(message = "Status is required")
        GameStatus status
) {
}
