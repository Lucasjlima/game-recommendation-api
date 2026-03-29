package br.com.fiap.game_recommendation.Game.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "game_id")
    private UUID id;

    @NaturalId
    @Column(name = "external_name", nullable = false, unique = true)
    private String externalName;

    @Column(nullable = false)
    private Double rating;

    @Column(name = "ratings_count")
    private Long ratingsCount;

    @Column(name = "background_image")
    private String backgroundImage;

    private String released;
}
