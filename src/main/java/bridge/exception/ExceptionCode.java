package bridge.exception;

public enum ExceptionCode {
    IS_EMPTY("[ERROR] 빈 값은 입력할 수 없습니다."),
    IS_BLANK("[ERROR] 공백은 입력할 수 없습니다."),
    HAS_BLANK("[ERROR] 공백이 포함된 값은 입력할 수 없습니다."),
    OUT_OF_RANGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    IS_NOT_INT("[ERROR] 숫자를 입력해야 합니다."),
    IS_NOT_MOVING("[ERROR] U 또는 D만 입력할 수 있습니다."),
    IS_NOT_GAME_COMMAND("[ERROR] R 또는 Q만 입력할 수 있습니다.");

    private final String message;

    ExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
