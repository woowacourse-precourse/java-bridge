package bridge.domain;

public enum GameResult {
    WIN(true, "성공"),
    OVER(false, "실패");

    private final boolean isSuccess;

    private final String message;

    GameResult(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
