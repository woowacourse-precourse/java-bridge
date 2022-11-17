package bridge;

public enum Space {
    UP("U"), DOWN("D");

    private final String value;

    Space(String value) {
        this.value = value;
    }

    public static Space from(int numberOfRow) {
        if (numberOfRow == 1) {
            return Space.UP;
        }
        return Space.DOWN;
    }

    public String getValue() {
        return value;
    }
}
