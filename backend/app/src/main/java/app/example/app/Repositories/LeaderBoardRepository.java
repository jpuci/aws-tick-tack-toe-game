package app.example.app.Repositories;

import app.example.app.Entities.LeaderBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface LeaderBoardRepository extends JpaRepository<LeaderBoard, Long> {
    LeaderBoard findLeaderBoardById(Long id);

    LeaderBoard findLeaderBoardByUsername(String username);
    ArrayList<LeaderBoard> findLeaderBoardByOrderByWonGamesDescDrawGamesDescLostGamesDesc();
}
