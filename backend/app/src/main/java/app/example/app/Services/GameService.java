package app.example.app.Services;

import app.example.app.Entities.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GameService {


    public char isWon(String board) {
        return checkWinner(board);
    }


    private static char checkWinner(String board) {
        // Winning combinations
        int[][] winCombinations = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
                {0, 4, 8}, {2, 4, 6}             // diagonals
        };

        // Check for a winner
        for (int[] combination : winCombinations) {
            if (board.charAt(combination[0]) != '.' &&
                    board.charAt(combination[0]) == board.charAt(combination[1]) &&
                    board.charAt(combination[1]) == board.charAt(combination[2])) {
                return board.charAt(combination[0]);
            }
        }

        // Check for ongoing game
        if (board.contains(".")) {
            return '.';
        }

        // Game is a draw
        return 'D';
    }

}
