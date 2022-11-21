package bridge.domain.ui;

public enum RetryOrQuit {

    RETRY("R"),
    QUIT("Q");

    private final String value;

    RetryOrQuit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
