package bridge.util;

public enum BridgeGameExceptionMessage {
    BRIDGE_SIZE_NUMBER_RANGE("다리의 길이는 3 이상 20 이하의 숫자여야 합니다."),
    RANDOM_NUMBER_NOT_MATCH("랜덤한 숫자에 해당하는 방향이 존재하지 않습니다."),
    DIRECTION_NOT_MATCH("입력은 위: U, 아래: D 여야만 합니다."),
    COMMAND_NOT_MATCH("입력은 재시도: R, 종료: Q 여야만 합니다.");

    private final String message;
    private static final String HEAD = "[ERROR] ";

    BridgeGameExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return HEAD + message;
    }
}
