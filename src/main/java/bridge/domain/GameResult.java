package bridge.domain;

public enum GameResult {
    SUCCESS("성공"),
    FAILURE("실패");

    private final String resultMessage;

    GameResult(final String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public static GameResult from(final boolean success) {
        if (success) {
            return GameResult.SUCCESS;
        }
        return GameResult.FAILURE;
    }

    public String toResultMessage() {
        return resultMessage;
    }
}
