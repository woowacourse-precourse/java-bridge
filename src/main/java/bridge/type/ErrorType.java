package bridge.type;

public enum ErrorType {
    INPUT_BRIDGE_SIZE_ERROR_TYPE("[ERROR] 3 이상 20 이하의 숫자만 입력 할 수 있습니다."),
    INPUT_RESUME_COMMAND_ERROR_TYPE("[ERROR] R와 Q만 입력하여야 합니다."),
    INPUT_SQUARE_ERROR_TYPE("[ERROR] U와 D만 입력하여야 합니다.");

    private final String text;

    ErrorType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
