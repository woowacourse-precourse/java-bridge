package bridge.constants;

public enum ErrorMessage {

    INVALID_BRIDGE_SIZE_ERROR("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_MOVING_ERROR("[ERROR] U 또는 D 둘 중 한 값을 입력해주세요."),
    INVALID_GAME_COMMAND_ERROR("[ERROR] R또는 Q 둘 중 한 값을 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
