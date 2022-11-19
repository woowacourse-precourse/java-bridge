package bridge.domain;


public enum Status {
    START(true, "START"),
    FAIL(false, "FAIL"),
    SUCCESS(false, "SUCCESS");

    private boolean status;
    private String message;

    Status(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}