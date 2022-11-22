package bridge.enums;

public enum ErrorMessage {
    INVALID_LENGTH("다리 길이는 " + ConstVariable.MIN_BRIDGE_LENGTH.getValue() + "부터 " + ConstVariable.MAX_BRIDGE_LENGTH.getValue() + " 사이의 숫자여야 합니다."),
    INVALID_INPUT("잘못된 값을 입력하셨습니다.");

    private final String value;
    private static final String errorHead = "[ERROR] ";
    private static final String errorTail = " 다시 입력하세요.";

    ErrorMessage(String value) {
        this.value = errorHead + value + errorTail;
    }

    public String getValue() {
        return value;
    }
}
