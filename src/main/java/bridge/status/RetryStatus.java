package bridge.status;

public enum RetryStatus {

    RETRY("R"),
    EXIT("Q");

    private String text;

    RetryStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
