package app.example.app.Entities;

public class Ask {
    private String status;
    private Long gameId;

    private String user1;

    private String user2;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
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

    public Ask(String status, Long gameId) {
        this.status = status;
        this.gameId = gameId;
    }


    public Ask(String status) {
        this.status = status;
    }

}
