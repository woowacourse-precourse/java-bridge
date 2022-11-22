package bridge.view.constant;

public enum RetryOptions {
    RETRY("R"),
    QUIT("Q");

    private final String option;

    private RetryOptions (String option) {
        this.option = option;
    }

    public String get() {
        return option;
    }
}
