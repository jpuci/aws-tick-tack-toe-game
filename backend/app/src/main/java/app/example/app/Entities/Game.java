package app.example.app.Entities;

import jakarta.persistence.*;

import java.lang.reflect.Array;

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
    private String board = (new int[3][3]).toString();

    public Game() {

    }
}
