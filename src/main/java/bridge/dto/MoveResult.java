package bridge.dto;

public class MoveResult {
    private Boolean gameOver;

    public MoveResult(Boolean gameOver) {
        this.gameOver = gameOver;
    }

    public Boolean isGameOver() {
        return gameOver;
    }

}