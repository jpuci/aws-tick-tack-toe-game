package app.example.app.Entities;

import jakarta.persistence.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

@Entity
@Table(name = "GAMES")
public class Game {
    public Game(Long id, String gameStatus, String board) {
        this.id = id;
        this.gameStatus = gameStatus;
        this.board = board;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="gameStatus")
    private String gameStatus = "Not initiated";

    @Column(name="board")
    private String board = ",,,,,,,,";

    public Game() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public ArrayList getArrayBoard(){
        return new ArrayList(Arrays.asList(this.board.split(",")));
    }
}
