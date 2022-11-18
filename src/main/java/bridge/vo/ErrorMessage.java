package bridge.vo;

public enum ErrorMessage {
    BRIDGE_SIZE_NOT_NUMBER("[ERROR] 다리 길이는 숫자로 입력 가능합니다."),
    BRIDGE_SIZE_WRONG_RANGE("[ERROR] 다리 길이는 3 이상 20 이하로 입력해야 합니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
