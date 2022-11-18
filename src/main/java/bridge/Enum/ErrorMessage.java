package bridge.Enum;

public enum ErrorMessage {
    NUMERIC_ERROR("[ERROR] 숫자를 입력해 주세요."),
    BRIDGE_SIZE_ERROR("[ERROR] "+BridgeSizeInfo.MIN_SIZE+"~"+BridgeSizeInfo.MAX_SIZE+" 사이의 숫자를 입력해 주세요.");

    final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
