package bridge.util;

public enum ExceptionMessage {
    COMMON("[ERROR] "),
    NULL("값을 입력하지 않았습니다."),
    NOT_NUMERIC("숫자가 아닌 값을 입력했습니다."),
    INVALID_CHARACTER("잘못된 문자를 입력했습니다."),
    OUT_OF_RANGE("%d 에서 %d 사이의 수를 입력해야합니다.");


    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String of() {
        return COMMON.message + message;
    }

    public String of(int min, int max) {
        return String.format(COMMON.message + message, min, max);
    }
}
