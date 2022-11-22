package bridge;

public class RetryResponseDto {
    private boolean retryGame;
    private int attemptCount;

    public RetryResponseDto(boolean retryGame, int attemptCount) {
        this.retryGame = retryGame;
        this.attemptCount = attemptCount;
    }

    public boolean isRetryGame() {
        return retryGame;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
