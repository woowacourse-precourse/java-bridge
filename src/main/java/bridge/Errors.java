package bridge;

public enum Errors {
    FAIL_INPUT("[ERRORS] 올바른 값을 입력해주세요");

    String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
