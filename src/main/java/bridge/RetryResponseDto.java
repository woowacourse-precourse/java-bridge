package bridge;

public class RetryResponseDto {
    private boolean retryGame;

    public RetryResponseDto(boolean retryGame) {
        this.retryGame = retryGame;
    }

    public boolean isRetryGame() {
        return retryGame;
    }
}
