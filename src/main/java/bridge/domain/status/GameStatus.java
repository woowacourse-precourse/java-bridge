package bridge.domain.status;

public enum GameStatus {
    RETRY("R"),
    QUIT("Q"),
    FIRST_TRY("P");

    private String gameStatusMessage;

    GameStatus(String gameStatusMessage) {
        this.gameStatusMessage = gameStatusMessage;
    }

    public static boolean checkGameStatus(GameStatus currentStatus) {
        if (GameStatus.FIRST_TRY.equals(currentStatus) || GameStatus.RETRY.equals(currentStatus)) {
            return true;
        }
        return false;
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
