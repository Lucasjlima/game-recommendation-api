package br.com.fiap.game_recommendation.User.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotBlank(message = "Nome de usuário é obrigatório")
        @Size(min = 3, message = "Nome de usuário deve ter no mínimo 3 caracteres")
        String username,
        @NotBlank(message = "Senha é obrigatória")
        @Size(min = 6, message = "Senha deve ter no mínimo 6 caracteres")
        String password
) {
}
