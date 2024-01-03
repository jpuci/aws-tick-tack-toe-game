package app.example.app.Entities;

public class Ask {
    private String status;
    private Long gameId;

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

    public Ask(String status, Long gameId) {
        this.status = status;
        this.gameId = gameId;
    }

    public Ask(String status) {
        this.status = status;
    }

}
