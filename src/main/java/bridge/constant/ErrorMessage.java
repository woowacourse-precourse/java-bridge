package bridge.constant;

public enum ErrorMessage {
    NO_INPUT_VALUE("입력값이 없습니다."),
    NOT_NUMBER("숫자가 아닙니다."),
    NOT_BRIDGE_SIZE_RANGE("다리의 길이는 3이상 20이하입니다."),
    NOT_MOVING_VALUE("U(위) 또는 D(아래)만 입력할 수 있습니다."),
    NOT_COMMAND_VALUE("R(재시작) 또는 Q(종료)만 입력할 수 있습니다.");

    private final String message;
    private String errorMark = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return errorMark + message;
    }
}
