package bridge.util;

public enum ExceptionMessage {

    OUT_OF_INT_RANGE("int 입력 범위를 초과했습니다."),
    INVALID_NOT_NUMERIC("숫자만 입력 가능합니다."),
    INVALID_NOT_IN_RANGE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    NO_BRIDGE_DIRECTION_NUMBER("0, 1 중의 숫자로 다리를 생성할 수 있습니다."),
    NO_BRIDGE_DIRECTION_SIGN("U, D 중의 입력값만 입력해 주세요."),
    NO_ROUND_STATUS("true, false 이외의 값으로는 Round Status를 찾을 수 없습니다."),
    INVALID_GAME_COMMAND("R, Q 중의 값만 입력할 수 있습니다.");
    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}