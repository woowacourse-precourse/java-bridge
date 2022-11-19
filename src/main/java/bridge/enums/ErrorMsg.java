package bridge.enums;

public enum ErrorMsg {
    ERROR_PREFIX("[ERROR] "),
    ERROR_INPUT_VALUE_IS_NOT_NUMBER("숫자만 입력해주세요.");

    private final String message;

    ErrorMsg(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
