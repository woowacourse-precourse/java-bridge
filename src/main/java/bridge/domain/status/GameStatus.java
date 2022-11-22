package bridge.domain.status;

public enum GameStatus {
    RETRY("R"),
    QUIT("Q"),
    PROCEED("P");

    private String gameStatus;

    GameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }

    public boolean checkGameStatus(GameStatus gameStatus) {
        return this.gameStatus.equals(gameStatus.gameStatus);
    }
}
