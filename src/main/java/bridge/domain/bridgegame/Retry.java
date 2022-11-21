package bridge.domain.bridgegame;

public enum Retry {
    RESTART("R"),
    QUIT("Q");

    private final String retryValue;

    Retry(final String retryValue) {
        this.retryValue = retryValue;
    }

    public String getRetryValue() {
        return retryValue;
    }
}
