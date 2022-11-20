package bridge;

public enum RetrySelector {
    RETRY("R"),
    QUIT("Q");

    private final String retrySelector;

    RetrySelector(String retrySelector) {
        this.retrySelector = retrySelector;
    }
}
