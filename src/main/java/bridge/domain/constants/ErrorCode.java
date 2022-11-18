package bridge.domain.constants;

public enum ErrorCode {
    SIZE_NOT_NUMBER("다리 길이는 숫자만 입력 가능합니다."),
    SIZE_NOT_IN_RANGE("다리 길이는 " + BridgeConstants.BRIDGE_SIZE_START + "부터 "
            + BridgeConstants.BRIDGE_SIZE_END + " 사이의 숫자여야 합니다."),
    MOVING_NOT_U_D("이동할 때 위 칸은 대문자 " + BridgeConstants.BRIDGE_GAME_MOVING_U + ", 아래 칸은 대문자 "
            + BridgeConstants.BRIDGE_GAME_MOVING_D + " 만 가능합니다."),
    GAME_COMMAND_NOT_R_Q(
            "재시도 여부 값은 재시도는 대문자 " + BridgeConstants.BRIDGE_GAME_COMMAND_R + ", 종료는 대문자 "
                    + BridgeConstants.BRIDGE_GAME_COMMAND_Q + " 만 가능합니다.");

    private static final String ERROR_BEGIN = "[ERROR] ";
    private final String errorMessage;

    ErrorCode(String message) {
        errorMessage = ERROR_BEGIN + message;
    }

    public RuntimeException getException() {
        return new IllegalArgumentException(errorMessage);
    }
}
