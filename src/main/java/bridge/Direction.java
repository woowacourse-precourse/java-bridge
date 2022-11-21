package bridge;

public enum Direction {
    UP("U"), DOWN("D");

    private final String value;

    Direction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
