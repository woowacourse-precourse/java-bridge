package bridge.model.message;

public enum ErrorMessage {
    ERROR_PREFIX("[ERROR] 잘못 입력했습니다."),
    ERROR_MOVING("[ERROR]U 또는 D를 입력해주세요."),
    ERROR_BRIDGE_SIZE("[ERROR] 다리길이는 3이상 20이하의 숫자를 입력해주세요"),
    ERROR_RETRY("[ERROR] 또는 Q를 입력해주세요.");
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
