package br.com.fiap.game_recommendation.usergame.repository;

import br.com.fiap.game_recommendation.usergame.entity.UserGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserGameRepository extends JpaRepository<UserGame, UUID> {
}
