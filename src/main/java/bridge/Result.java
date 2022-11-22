package bridge;

public enum Result {
    SUCCESS("성공"),
    FAIL("실패");

    private final String message;

    Result(String message) {
        this.message = message;
    }

    public boolean isFail() {
        return this == FAIL;
    }

    public boolean isSuccess() {
        return this == SUCCESS;
    }

    public String getMessage() {
        return message;
    }
}
