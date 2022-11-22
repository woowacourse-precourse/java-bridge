package data;

public enum Errors {
    NOT_NUMERIC("입력값은 숫자이어야 합니다."),
    NOT_RANGE("입력값은 3~20 이어야 합니다..");

    private final String message;

    Errors(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
