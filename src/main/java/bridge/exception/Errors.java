package bridge.exception;

public enum Errors {
    INVALID_PARAMETER("파라미터의 값이 잘못 되었습니다."),
    EMPTY_INPUT("값을 입력해 주세요."),
    CANNOT_CHARACTER_FORMAT("숫자 형식을 입력해주세요."),
    INPUT_RIGHT_RANGE("3이상 20이하의 숫자를 입력해주세요."),
    NOT_RIGHT_MOVE_COMMAND("U나 D로만 움직일 수 있습니다."),
    NOT_RIGHT_GAME_COMMAND("R나 Q만 입력할 수 있습니다.");

    private static final String DEFAULT_MESSAGE = "[ERROR] ";

    private final String message;

    Errors(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return DEFAULT_MESSAGE + this.message;
    }
}
