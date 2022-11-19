package bridge.Enum;

public enum ErrorMessage {
    NUMERIC_ERROR("[ERROR] 숫자를 입력해주세요."),
    BRIDGE_SIZE_ERROR("[ERROR] "+ BridgeInfo.MIN_SIZE+"~"+ BridgeInfo.MAX_SIZE+" 사이의 숫자를 입력해주세요."),
    UPDWON_INPUT_ERROR("[ERROR] U와 D 중 하나를 입력해주세요."),
    RESTART_INPUT_ERROR("[ERROR] R와 Q 중 하나를 입력해주세요.");
    final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
