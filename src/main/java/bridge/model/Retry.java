package bridge.model;

public enum Retry {
    R("R", true),
    Q("Q", false);

    private final String value;
    private final boolean isRetry;

    Retry(String value, boolean isRetry) {
        this.value = value;
        this.isRetry = isRetry;
    }

    public boolean isRetry() {
        return isRetry;
    }
}
