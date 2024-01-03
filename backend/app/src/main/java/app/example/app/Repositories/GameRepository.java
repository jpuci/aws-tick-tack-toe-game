package app.example.app.Repositories;

import app.example.app.Entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Game findGameById(Long id);
    Game findGameByGameStatus(String gameStatus);
}
