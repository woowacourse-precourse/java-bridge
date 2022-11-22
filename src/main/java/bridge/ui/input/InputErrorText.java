package bridge.ui.input;

public enum InputErrorText {
    ERROR_BRIDGE_NUMBER("다리 길이는 숫자만 입력 가능 합니다."),
    ERROR_BRIDGE_SIZE("다리 길이는 3 ~ 20 사이 이어야 합니다."),
    ERROR_MOVE_COMMAND("이동할 칸 선택 시, \"U\" 또는 \"D\"만 입력 가능 합니다."),
    ERROR_RESTART_COMMAND("재시작 선택 시, \"R\" 또는 \"Q\"만 입력 가능 합니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String errorText;

    InputErrorText(String errorText) {
        this.errorText = ERROR_PREFIX + errorText;
    }

    public String errorText() {
        return this.errorText;
    }
}
