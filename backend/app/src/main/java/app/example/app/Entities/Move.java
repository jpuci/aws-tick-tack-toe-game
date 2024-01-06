package app.example.app.Entities;

public class Move {

    private String board;

    private String moveType;

    private Long gameId;

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getMoveType() {
        return moveType;
    }

    public void setMoveType(String moveType) {
        this.moveType = moveType;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Move(String board, String moveType, Long gameId) {
        this.board = board;
        this.moveType = moveType;
        this.gameId = gameId;
    }
}
