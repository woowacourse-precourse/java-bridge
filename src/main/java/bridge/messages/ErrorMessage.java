package bridge.messages;

public enum ErrorMessage {
    BRIDGE_IS_EMPTY("[ERROR] 값을 찾을 수 없습니다."),
    BRIDGE_HAS_WRONG_DATA("[ERROR] 잘못된 값이 추가되었습니다."),
    BRIDGE_SIZE_INPUT_RANGE("[ERROR] 3이상 20이하의 숫자를 입력해야합니다."),
    BRIDGE_SIZE_INPUT_TYPE("[ERROR] 다리 길이는 숫자를 입력해야합니다."),
    INPUT_NULL("[ERROR] 아무런 값을 입력하지 않았습니다."),
    BRIDGE_INPUT_NUMBER("[ERROR] 숫자를 입력할 수 없습니다.\n문자를 입력해주세요."),
    BRIDGE_MOVE_INPUT("[ERROR] 잘못된 값을 입력하셨습니다.\n이동할 칸은 \"U\" 또는 \"D\" 중 하나의 문자만 입력할 수 있습니다."),
    BRIDGE_MOVE_INPUT_LOWERCASE("[ERROR] 소문자가 아닌 대문자로 입력해야합니다.\n\"U\" 또는 \"D\"를 입력해주세요."),
    BRIDGE_RESTART_INPUT("[ERROR] 잘못된 값을 입력하셨습니다.\n\"R\" 또는 \"Q\" 중 하나의 문자만 입력할 수 있습니다."),
    BRIDGE_RESTART_INPUT_LOWERCASE("[ERROR] 소문자가 아닌 대문자로 입력해야합니다.\n\"R\" 또는 \"Q\"를 입력해주세요.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
