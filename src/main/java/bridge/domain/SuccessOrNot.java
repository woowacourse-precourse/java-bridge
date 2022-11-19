package bridge.domain;

public enum SuccessOrNot {
    SUCCESS("성공"),
    FAIL("실패");

    private final String message;

    private SuccessOrNot(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
