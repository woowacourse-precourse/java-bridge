package bridge.domain;

public enum GameStatus {
    SUCCESS(false, "성공"),
    IN_PROGRESS(false, "진행중"),
    FAIL(true, "실패");

    private final boolean retry;
    private final String details;

    GameStatus(boolean retry, String details) {
        this.retry = retry;
        this.details = details;
    }

    public boolean needCallRetry() {
        return this.retry;
    }

    public String getDetails() {
        return details;
    }

    public boolean isFail() {
        return this.equals(FAIL);
    }
}
