package bridge.model.constant;

public enum Result {
    CAN_CROSS("O"),
    CANNOT_CROSS("X"),
    UNKNOWN(" ");

    private final String value;

    Result(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
