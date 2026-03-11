package br.com.fiap.game_recommendation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GameResult(
        @JsonProperty("name")
        String name,
        @JsonProperty("rating")
        Double rating,
        @JsonProperty("ratings_count")
        Long ratingCounts,
        @JsonProperty("background_image")
        String backgroundImage,
        @JsonProperty("released")
        String released
) {
}
