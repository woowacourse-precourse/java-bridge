package bridge.command;

public enum Direction {
    UP(1, "U"),
    DOWN(0, "D");

    private final String text;
    private final int number;

    private Direction(int number, String text) {
        this.number = number;
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public int getNumber() {
        return this.number;
    }
}
