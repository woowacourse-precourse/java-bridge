package bridge.validator.code;

public enum BridgeSizeValidationCode {
    ILLEGAL_CHARACTER("다리 길이 입력은 3 이상 20 이하의 숫자여야 하며, 숫자 외 다른 문자를 포함해서는 안 됩니다."),
    INVALID_NUMBER_FORMAT("다리 길이 입력은 부호 없는 10진수로 표기된 3 이상 20 이하 숫자여야 합니다"),
    NUMBER_OUT_OF_RANGE("다리 길이 입력은 3 이상 20 이하의 숫자여야만 합니다."),
    VALID("올바른 다리 길이 입력입니다.");

    private final String errorMessage;

    BridgeSizeValidationCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
