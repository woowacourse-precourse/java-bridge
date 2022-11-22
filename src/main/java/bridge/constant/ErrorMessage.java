package bridge.constant;

import static bridge.constant.BridgeConstant.*;
import static bridge.constant.GameCommand.*;

public enum ErrorMessage {
    ERROR_INVALID_BRIDGE_SIZE(
            String.format("[ERROR] 다리 길이는 %d부터 %d 사이의 숫자여야 합니다.",
                    BRIDGE_SIZE_START_INCLUSIVE.getValue(),
                    BRIDGE_SIZE_END_INCLUSIVE.getValue())
    ),

    ERROR_INVALID_USER_STEP(
            String.format("[ERROR] 이동할 칸으로 위: %s, 아래: %s를 입력해주세요.",
                    USER_STEP_FOR_UPPER_LAYER.getCommand(),
                    USER_STEP_FOR_LOWER_LAYER.getCommand())
    ),

    ERROR_INVALID_RETRY_COMMAND(
            String.format("[ERROR] 게임 재시작 여부로 재시도: %s, 종료: %s를 입력해주세요.",
                    COMMAND_FOR_RETRY.getCommand(),
                    COMMAND_FOR_QUIT.getCommand())
    );

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
