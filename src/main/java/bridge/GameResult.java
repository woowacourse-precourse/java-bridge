package bridge;

public class GameResult {
    public static final String GAME_COMPLETE = "성공";
    public static final String GAME_FAIL = "실패";
    private final boolean success;
    private final int retryCount;

    public GameResult(boolean success, int retryCount) {
        this.success = success;
        this.retryCount = retryCount;
    }

    public String getResult() {
        if (success) {
            return GAME_COMPLETE;
        }
        return GAME_FAIL;
    }

    public int getRetryCount() {
        return retryCount;
    }
}
