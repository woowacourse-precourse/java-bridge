package bridge.type;

public enum ErrorType {
    INPUT_ERROR_TYPE("[ERROR] 3 이상 20 이하의 숫자만 입력 할 수 있습니다.");

    private final String text;

    ErrorType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
