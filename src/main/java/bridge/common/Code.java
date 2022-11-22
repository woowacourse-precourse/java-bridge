package bridge.common;

public enum Code {
    SUCCESS("성공"),
    FAILURE("실패");

    private String message;

    Code(String message) {
        this.message = message;
    }

    public static Code of(Long failCount) {
        if (failCount == 0) {
            return SUCCESS;
        }
        return FAILURE;
    }

    @Override
    public String toString() {
        return message;
    }

    public boolean isSuccess() {
        return this.equals(SUCCESS);
    }
}
