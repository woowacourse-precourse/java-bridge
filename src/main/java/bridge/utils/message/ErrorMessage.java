package bridge.utils.message;

public enum ErrorMessage {

    INVALID_INPUT_VALUE("올바르지 않은 값입니다."),
    BRIDGE_OUT_OF_RANGE("올바르지 않은 값입니다. 다리길이는 3 ~ 20사이의 값이여야합니다."),
    INVALID_MOVING_COMMAND("올바르지 않은 값입니다. 이동값은 U, D 중 하나입니다."),
    INVALID_GAME_COMMAND("올바르지 않은 값입니다. 재시작은 R, 종료는 Q를 입력해야합니다.");

    private final String message;
    private static final String prefix = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + this.message;
    }
    
}
