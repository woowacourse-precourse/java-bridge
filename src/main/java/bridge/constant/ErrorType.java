package bridge.constant;

public enum ErrorType {
    NUMBER_ERROR("숫자를 입력해야 합니다."),
    BRIDGE_RANGE_ERROR("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    MOVING_INPUT_ERROR("이동할 칸은 U 또는 D를 입력해야 합니다."),
    GAME_COMMAND_ERROR("R 또는 Q를 입력해주세요."),
    ;

    private final String message;

    ErrorType(String message) {
        this.message = Prefix.MESSAGE + message;
    }

    public String getMessage() {
        return message;
    }

    private static class Prefix {
        private static final String MESSAGE = "[ERROR] ";
    }
}
