package bridge.enums;

public enum ErrorMsg {
    ERROR_PREFIX("[ERROR] "),
    ERROR_INPUT_VALUE_IS_NOT_NUMBER("숫자만 입력 가능합니다."),
    ERROR_BRIDGE_SIZE_IS_NOT_BETWEEN_3_AND_20("다리 길이는 3 이상 20 이하의 숫자만 입력 가능합니다.");

    private final String message;

    ErrorMsg(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
