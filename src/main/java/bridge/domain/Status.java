package bridge.domain;

public enum Status {
    SUCCESS("성공"),
    FAIL("실패");

    private final String message;

    Status(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
