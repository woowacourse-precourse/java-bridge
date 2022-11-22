package bridge.domain.constants;


import static bridge.domain.constants.BridgeConstants.BRIDGE_GAME_COMMAND_QUIT;
import static bridge.domain.constants.BridgeConstants.BRIDGE_GAME_COMMAND_RETRY;
import static bridge.domain.constants.BridgeConstants.BRIDGE_GAME_MOVING_DOWN;
import static bridge.domain.constants.BridgeConstants.BRIDGE_GAME_MOVING_UP;
import static bridge.domain.constants.BridgeConstants.BRIDGE_SIZE_END;
import static bridge.domain.constants.BridgeConstants.BRIDGE_SIZE_START;

public enum ErrorCode {
    SIZE_NOT_IN_RANGE("다리 길이는 " + BRIDGE_SIZE_START + "부터 "
            + BRIDGE_SIZE_END + " 사이의 숫자여야 합니다."),
    MOVING_NOT_U_D("이동할 때 위 칸은 대문자 " + BRIDGE_GAME_MOVING_UP + ", 아래 칸은 대문자 "
            + BRIDGE_GAME_MOVING_DOWN + " 만 가능합니다."),
    GAME_COMMAND_NOT_R_Q(
            "재시도 여부 값은 재시도는 대문자 " + BRIDGE_GAME_COMMAND_RETRY + ", 종료는 대문자 "
                    + BRIDGE_GAME_COMMAND_QUIT + " 만 가능합니다.");

    private static final String ERROR_BEGIN = "[ERROR] ";
    private final String errorMessage;

    ErrorCode(String message) {
        errorMessage = ERROR_BEGIN + message;
    }

    public RuntimeException getException() {
        return new IllegalArgumentException(errorMessage);
    }
}
