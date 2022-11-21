package bridge.domain;

public enum GameResult {
    FAILURE("실패"), SUCCESS("성공");

    private final String message;

    GameResult(String message) {
        this.message = message;
    }

    public static String valueOf(boolean isSuccess) {
        if (isSuccess) {
            return SUCCESS.message;
        }
        return FAILURE.message;
    }
}
