package app.example.app.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "leaderboard")
public class LeaderBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="wonGames")
    private Integer wonGames = 0;

    @Column(name="lostGames")
    private Integer lostGames = 0;

    @Column(name="drawGames")
    private Integer drawGames = 0;


    public LeaderBoard(Long id, String username, Integer wonGames, Integer lostGames, Integer drawGames) {
        this.id = id;
        this.username = username;
        this.wonGames = wonGames;
        this.lostGames = lostGames;
        this.drawGames = drawGames;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getWonGames() {
        return wonGames;
    }

    public void setWonGames(Integer wonGames) {
        this.wonGames = wonGames;
    }

    public Integer getLostGames() {
        return lostGames;
    }

    public void setLostGames(Integer lostGames) {
        this.lostGames = lostGames;
    }

    public Integer getDrawGames() {
        return drawGames;
    }

    public void setDrawGames(Integer drawGames) {
        this.drawGames = drawGames;
    }

    public LeaderBoard(String username) {
        this.username = username;
    }

    public LeaderBoard() {
    }
}
