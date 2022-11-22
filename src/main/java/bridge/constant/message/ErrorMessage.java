package bridge.constant.message;

public enum ErrorMessage {

    NOTICE("[ERROR] "),
    ERROR_INPUT_LENGTH_RANGE("3 ~ 20 사이의 값만 입력 가능합니다."),
    ERROR_INPUT_MOVE_RANGE("U 혹은 D만 입력가능 합니다."),
    ERROR_INPUT_END_RANGE("R 혹은 Q만 입력가능 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
