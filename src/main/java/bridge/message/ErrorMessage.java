package bridge.message;

public enum ErrorMessage {
    WARNING_BRIDGE_SIZE_RANGE("[ERROR] 다리길이는 3이상 20이하의 숫자를 입력해주세요"),
    WARNING_BRIDGE_INPUT_TYPE("[ERROR] 다리길이는 3이상 20이하의 숫자를 입력해주세요");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
