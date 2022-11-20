package bridge.constant.enums;

public enum Moving {

    UP("U", 1),
    DOWN("D", 0);

    private final String value;
    private final int number;

    Moving(String value, int number) {
        this.value = value;
        this.number = number;
    }

    public String getValue() {
        return value;
    }

    public int getNumber() {
        return number;
    }
}
