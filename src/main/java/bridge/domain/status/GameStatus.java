package bridge.domain.status;

public enum GameStatus {
    RETRY("R"),
    QUIT("Q"),
    PROCEED("P"),
    SUCCESS("성공"),
    FAIL("실패");

    private String gameStatusMessage;

    GameStatus(String gameStatusMessage) {
        this.gameStatusMessage = gameStatusMessage;
    }

    public String getGameStatusMessage() {
        return gameStatusMessage;
    }

    public static boolean checkIsRetryStatus(GameStatus currentStatus) {
        if (GameStatus.RETRY.equals(currentStatus)) {
            return true;
        }
        return false;
    }

    public static boolean checkIsProceedStatus(GameStatus currentStatus) {
        if (GameStatus.PROCEED.equals(currentStatus)) {
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
