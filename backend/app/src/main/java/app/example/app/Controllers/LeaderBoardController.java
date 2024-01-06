package app.example.app.Controllers;

import app.example.app.Entities.LeaderBoard;
import app.example.app.Repositories.LeaderBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class LeaderBoardController {

    @Autowired
    LeaderBoardRepository leaderBoardRepository;

    @GetMapping("/get-leaderboard")
    public ResponseEntity<ArrayList<LeaderBoard>> getLeaderBoard(){
        ArrayList<LeaderBoard> leaderBoard = leaderBoardRepository.findLeaderBoardByOrderByWonGamesDescDrawGamesDescLostGamesDesc();
        return ResponseEntity.ok(leaderBoard);
    }
}
