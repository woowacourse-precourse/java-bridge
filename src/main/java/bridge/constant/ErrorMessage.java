package bridge.constant;

public enum ErrorMessage {
    EMPTY_VALUE("값을 입력하지 않았습니다."),
    NOT_NUMBER("숫자만 입력해주세요."),
    INVALID_BRIDGE_LENGTH("다리의 길이로는 " + BridgeProperties.MIN_LENGTH.get() + "부터 "
            + BridgeProperties.MAX_LENGTH.get() +"까지의 숫자만 허용됩니다.");

    private final String ERROR_PREFIX = "[ERROR] ";
    private final String errorMessage;

    private ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String get() {
        return ERROR_PREFIX + errorMessage;
    }
}
