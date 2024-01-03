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
    @Column(name="id")
    private Long id;

    @Column(name="gameStatus")
    private String gameStatus = "Not Started";

    @Column(name="board")
    private String board = ".........";

    @Column(name="user1")
    private String user1;

    @Column(name="user2")
    private String user2;

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

    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public String getUser2() {
        return user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    public ArrayList getArrayBoard(){
        return new ArrayList(Arrays.asList(this.board.split(",")));
    }
}
