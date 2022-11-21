package bridge;

public enum Direction {
    Down("D"),
    Up("U");

    private final String string;

    Direction(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
