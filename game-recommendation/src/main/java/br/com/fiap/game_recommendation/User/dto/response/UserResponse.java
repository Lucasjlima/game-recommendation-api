package br.com.fiap.game_recommendation.User.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserResponse(
        Long id,
        String username,
        LocalDateTime createdAt
) {
}
