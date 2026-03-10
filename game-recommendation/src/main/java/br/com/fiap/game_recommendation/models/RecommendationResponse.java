package br.com.fiap.game_recommendation.models;

public record RecommendationResponse(
        String name,
        double rating,
        Long ratingCounts,
        String recommendation
)
{}
