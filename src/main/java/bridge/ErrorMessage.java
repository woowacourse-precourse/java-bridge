package bridge;

public enum ErrorMessage {

    BRIDGE_LENGTH_IS_ONLY_NUMBER("[ERROR] 숫자만 입력해야 합니다."),
    BRIDGE_LENGTH_IS_THREE_TO_TWENTY("[ERROR] 다리의 길이는 3이상 20이하여야 합니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
