package app.example.app.Entities;

public class Move {
    private Integer id;
    private Integer moveType;

    private Integer gameId;

    public Move(Integer id, Integer moveType) {
        this.id = id;
        this.moveType = moveType;
    }

    public Integer getId() {
        return id;
    }

    public Integer getMoveType() {
        return moveType;
    }

    public void setMoveType(Integer moveType) {
        this.moveType = moveType;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
}
