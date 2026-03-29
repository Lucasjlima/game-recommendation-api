package br.com.fiap.game_recommendation.usergame.entity;

import br.com.fiap.game_recommendation.User.entity.User;
import br.com.fiap.game_recommendation.Game.entity.Game;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_games")
public class UserGame {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_game_id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @CreationTimestamp
    @Column(name = "saved_at", nullable = false, updatable = false)
    private LocalDateTime savedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GameStatus status;
}
