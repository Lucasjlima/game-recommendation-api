package br.com.fiap.game_recommendation.Game.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RawgResponse(
        @JsonProperty("results")
        List<GameResult> results
) {
}
