package bridge.ui.input;

public enum InputErrorText {
    ERROR_BRIDGE_SIZE("다리 길이는 3부터 20 사이의 숫자만 입력 가능 합니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String errorText;

    InputErrorText(String errorText) {
        this.errorText = ERROR_PREFIX + errorText;
    }

    public String errorText() {
        return this.errorText;
    }
}
