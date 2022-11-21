package bridge.error;

public enum ERROR_MESSAGE {
    NOT_INTEGER_BRIDGE_SIZE("[ERROR] 입력 값은 숫자여야 합니다."),
    NOT_RANGE_OF_BRIDGE_SIZE("[ERROR] 입력 값은 3이상 20이하여야 합니다."),
    NOT_TYPE_OF_MOVING("[ERROR] 입력 값은 U 또는 D여야 합니다."),
    NOT_TYPE_OF_GAME_COMMAND("[ERROR] 입력 값은 R 또는 Q여야 합니다.");

    private final String message;

    ERROR_MESSAGE(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
