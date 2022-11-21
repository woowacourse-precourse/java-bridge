package bridge.domain;

import bridge.Constants;

public enum InputErrorMessage {
    PREFIX("[ERROR]"),
    BRIDGE_NUMBER(String.format("%s 숫자만 입력해야 합니다.", PREFIX.message())),
    BRIDGE_SIZE(String.format("%s 다리 길이는 %d부터 %d 사이의 숫자여야 합니다.",
            PREFIX.message(), Constants.BRIDGE_SIZE_MIN, Constants.BRIDGE_SIZE_MAX)),
    MOVING(String.format("%s %s, %s 중 하나를 입력해야 합니다.",
            PREFIX.message(), Constants.CODE_UP, Constants.CODE_DOWN)),
    GAME_COMMAND(String.format("%s %s, %s 중 하나를 입력해야 합니다.",
            PREFIX.message(), Constants.CODE_RETRY, Constants.CODE_QUIT));
    private final String message;

    InputErrorMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
