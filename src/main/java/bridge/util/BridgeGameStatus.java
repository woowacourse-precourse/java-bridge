package bridge.util;

public enum BridgeGameStatus {
    RESTART("R"),
    QUIT("Q");

    private final String gameStatus;

    BridgeGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }

    public String getGameStatus() {
        return gameStatus;
    }
}
