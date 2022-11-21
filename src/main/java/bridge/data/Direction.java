package bridge.data;

public enum Direction {
    Up("U"),
    Down("D");

    private final String string;

    Direction(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }

    public boolean equals(String input) {
        return string.equals(input);
    }
}
