package bridge.exception;

public enum BridgeGameError {
    BRIDGE_SIZE_NOT_INTEGER("[ERROR] 다리 길이는 숫자를 입력해야 합니다."),
    BRIDGE_SIZE_EXCLUDE_RANGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_GAME_COMMAND_INPUT("[ERROR] R,Q를 입력해 주세요."),
    INVALID_MOVE_COMMAND_INPUT("[ERROR] U,D를 입력해 주세요."),
    NOT_ZERO_OR_ONE("[ERROR] 다리는 0,1로 칸을 정해야 합니다.");

    private final String errorMessage;

    BridgeGameError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
