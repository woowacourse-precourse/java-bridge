package bridge.domain.status;

public enum GameStatus {
    RETRY("R"),
    QUIT("Q"),
    PROCEED("P");

    private String gameStatusMessage;

    GameStatus(String gameStatusMessage) {
        this.gameStatusMessage = gameStatusMessage;
    }

    public boolean checkGameStatus(GameStatus gameStatus) {
        return this.gameStatusMessage.equals(gameStatus.gameStatusMessage);
    }

    public static GameStatus convertGameStatus(String inputStatus) {
        return java.util.Arrays.stream(GameStatus.values())
            .filter(gameStatus -> gameStatus.compareTo(inputStatus))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException());
    }

    public boolean compareTo(String inputStatus) {
        return inputStatus.equals(this.gameStatusMessage);
    }

}
