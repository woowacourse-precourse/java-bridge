package bridge.resource;

public enum ErrorMessage {
    NOT_INTEGER_OR_NUMBER_OUT_OF_RANGE_MESSAGE("입력된 값이 숫자가 아니거나 Integer 범위를 벗어났습니다."),
    NOT_BETWEEN_3_AND_20_MESSAGE("3~20 범위를 벗어났습니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return "[ERROR] " + value;
    }
}
