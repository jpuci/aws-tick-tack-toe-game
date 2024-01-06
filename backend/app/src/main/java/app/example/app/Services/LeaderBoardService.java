package app.example.app.Services;

import app.example.app.Entities.LeaderBoard;
import app.example.app.Repositories.LeaderBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaderBoardService {

    @Autowired
    LeaderBoardRepository leaderBoardRepository;

    public void saveGameResults(String results, String username1, String username2){
        LeaderBoard user1Results = leaderBoardRepository.findLeaderBoardByUsername(username1);
        LeaderBoard user2Results = leaderBoardRepository.findLeaderBoardByUsername(username2);

        if (user1Results == null){
            user1Results = new LeaderBoard(username1);
        }
        if (user2Results == null){
            user2Results = new LeaderBoard(username2);
        }
        if (results.equals("X")){
            user1Results.setLostGames(user1Results.getLostGames() + 1);
            user2Results.setWonGames(user2Results.getWonGames() + 1);
        } else if (results.equals("O")){
            user2Results.setLostGames(user2Results.getLostGames() + 1);
            user1Results.setWonGames(user1Results.getWonGames() + 1);
        } else if (results.equals("D")){
            user2Results.setDrawGames(user2Results.getDrawGames() + 1);
            user1Results.setDrawGames(user1Results.getDrawGames() + 1);
        }

        leaderBoardRepository.save(user1Results);
        leaderBoardRepository.save(user2Results);
    }
}
