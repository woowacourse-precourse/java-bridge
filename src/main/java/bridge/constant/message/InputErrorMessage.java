package bridge.constant.message;

import static bridge.constant.Config.*;

public enum InputErrorMessage implements ErrorMessage {
    NO_NUMERIC_STRING("입력값이 숫자 형태가 아닙니다."),
    NO_RANGE_OF_BRIDGE_SIZE(
            "다리 길이는 " + RANGE_OF_BRIDGE_SIZE_START + "부터 " + RANGE_OF_BRIDGE_SIZE_END + " 사이의 숫자여야 합니다."),
    NO_VALID_MOVING("유효하지 않은 칸 이동 명령입니다."),
    NO_VALID_GAME_COMMAND("유효하지 않은 게임 관련 명령입니다.");

    private String message;

    InputErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
