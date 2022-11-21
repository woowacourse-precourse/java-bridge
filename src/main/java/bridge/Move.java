package bridge;

public enum Move {
    DOWN("D"),
    UP("U");

    private final String value;

    Move(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
