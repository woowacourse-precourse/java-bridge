package bridge.util;

public enum UpDown {
    UP(1, "U"), DOWN(0, "D");

    private final int number;
    private final String value;

    UpDown(int number, String value) {
        this.number = number;
        this.value = value;
    }

    public int getNumber() {
        return number;
    }

    public String getValue() {
        return value;
    }
}
