package bridge.domain.bridgegame;

public enum Retry {
    RESTART("R"),
    QUIT("Q");

    private final String retryValue;

    Retry(final String retryValue) {
        this.retryValue = retryValue;
    }

    public static Retry findRetry(String input) {
        if (!input.equals(RESTART.getRetryValue())) {
            return QUIT;
        }
        return RESTART;
    }

    public String getRetryValue() {
        return retryValue;
    }
}
