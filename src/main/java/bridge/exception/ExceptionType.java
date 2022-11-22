package bridge.exception;

public enum ExceptionType {
    GAME_COMMAND_EXCEPTION("[ERROR] Q 또는 R만 입력할 수 있습니다"),
    MOVE_TYPE_EXCEPTION("[ERROR] U 또는 D만 입력할 수 있습니다."),
    INTEGER_TYPE_EXCEPTION("[ERROR] 정수 값이 입력되어야 합니다."),
    BRIDGE_RANGE_EXCEPTION("[ERROR] 3이하 20이하의 수를 입력해야 합니다"),
    ;

    private final String errorMessage;

    ExceptionType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
