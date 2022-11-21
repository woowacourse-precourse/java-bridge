package bridge;

public enum RetrySelector {
    RETRY("R"),
    QUIT("Q");

    private final String retrySelector;

    RetrySelector(String retrySelector) {
        this.retrySelector = retrySelector;
    }

    public static RetrySelector getRetrySelectorType(String retrySelector) {
        if (retrySelector.equals("R")) {
            return RetrySelector.RETRY;
        }
        return RetrySelector.QUIT;
    }

    public String getRetrySelector() {
        return retrySelector;
    }
}
