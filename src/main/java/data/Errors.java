package data;

public enum Errors {

    NOT_NUMERIC("입력값은 숫자이어야 합니다."),
    NOT_RANGE("입력값은 3~20 이어야 합니다.."),
    NOT_UORD("U 또는 D를 입력해 주세요."),
    NOT_RORQ("R 또는 Q를 입력해 주세요.");

    private final String message;

    Errors(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
