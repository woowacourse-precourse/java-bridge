package bridge;

public enum Position {
    UP(1, "U"), DOWN(0, "D");

    private int code;
    private String value;
    Position(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
