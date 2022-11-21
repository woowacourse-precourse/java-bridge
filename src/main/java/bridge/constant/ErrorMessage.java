package bridge.constant;

import bridge.domain.Bridge;
import bridge.domain.Moving;

public enum ErrorMessage {
    INPUT_IS_EMPTY_ERROR("빈 값이 입력되었습니다."),
    INPUT_HAS_CHARACTER_ERROR("문자가 입력되었습니다."),

    NOT_VALID_BRIDGE_SIZE(
            String.format("다리의 길이가 %d이상 %d이하 숫자여야 합니다.",
                    Bridge.getBridgeMinSize(),
                    Bridge.getBridgeMaxSize()
                    )
    ),
    NOT_VALID_MOVING_CHARACTER(
            String.format("이동 칸은 %s 또는 %s 문자여야 합니다.",
                    Moving.getMovingUpCharacter(),
                    Moving.getMovingDownCharacter()
                    )
    );

    private static final String ERROR = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return ERROR + message;
    }
}
