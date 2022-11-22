package bridge.domain;

public enum Result {
    SUCCESS("성공"),
    CONTINUE("계속"),
    FAIL("실패");

    private final String statusMessage;

    Result(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getStatusMessage() {
        return statusMessage;
    }
}
