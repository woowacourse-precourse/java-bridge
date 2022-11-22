package bridge.exception;

public enum BridgeGameError {
    BRIDGE_SIZE_NOT_NUMBER("[ERROR] 다리 길이는 숫자만 입력해 주세요"),
    BRIDGE_SIZE_NOT_INCLUDE_RANGE("[ERROR] 다리 길이는 3 이상 20 이하로 입력해 주세요."),
    INVALID_TYPE_GAME_COMMAND("[ERROR] R, Q를 입력해 주세요."),
    INVALID_TYPE_MOVE_COMMAND("[ERROR] U, D를 입력해 주세요."),
    INVALID_TYPE_START_PLAY_COMMAND("[ERROR] 0, 1로 다리의 칸을 입력해 주세요.");

    private final String errorMessage;

    BridgeGameError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}