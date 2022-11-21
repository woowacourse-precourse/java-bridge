package bridge.type;

import static bridge.type.CommonConstantType.MAX_BRIDGE_SIZE;
import static bridge.type.CommonConstantType.MIN_BRIDGE_SIZE;

public enum ErrorMessageUserType {

    INVALID_NUMBER_FORMAT("숫자를 입력해야 합니다."),
    INVALID_BRIDGE_SIZE("다리 길이는 %d ~ %d 사이의 값을 입력해야 합니다.",
            MIN_BRIDGE_SIZE, MAX_BRIDGE_SIZE),
    INVALID_IN_GAME_COMMAND("%s 중 하나를 입력해야 합니다.",
            "[" + InGameCommandType.getDescription() + "]"),
    INVALID_FAIL_MENU_COMMAND("%s 중 하나를 입력해야 합니다.",
            "[" + FailMenuCommandType.getDescription() + "]");

    private final static String ERROR_HEAD = "[ERROR] ";
    private final String message;

    ErrorMessageUserType(String message, Object... replacers) {
        this.message = ERROR_HEAD + String.format(message, replacers);
    }

    @Override
    public String toString() {
        return message;
    }
}
