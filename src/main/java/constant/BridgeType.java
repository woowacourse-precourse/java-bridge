package constant;

public enum BridgeType {

    DOWN(0, "D"),
    UP(1, "U");

    private final int value;
    private final String mark;

    BridgeType(int value, String mark) {
        this.value = value;
        this.mark = mark;
    }

    public int getValue() {
        return value;
    }

    public String getMark() {
        return mark;
    }
}
