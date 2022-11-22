package bridge.common;

public enum Code {
    SUCCESS("성공"),
    FAILURE("실패");

    private String message;

    Code(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    public boolean isSuccess() {
        return this.equals(SUCCESS);
    }
}
