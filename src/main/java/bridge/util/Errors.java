package bridge.util;

public enum Errors {
    IS_EMPTY("[ERROR] 값을 입력해야 합니다.\n"),
    OUT_OF_BOUND("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.\n"),
    NOT_NUMBER("[ERROR] 다리 길이는 숫자여야 합니다.\n"),
    NOT_UPPERCASE("[ERROR] 대문자로 입력해야 합니다.\n"),
    INVALID_MOVE_VALUE("[ERROR] 이동할 칸 입력은 U 혹은 D 여야 합니다.\n"),
    INVALID_CONTINUE_VALUE("[ERROR] 재시작 여부 입력은 R 혹은 Q 여야 합니다.\n");

    private final String message;

    Errors(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
