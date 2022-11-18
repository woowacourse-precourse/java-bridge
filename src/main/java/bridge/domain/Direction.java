package bridge.domain;

public enum Direction {
    UP("U", 1, 0),
    DOWN("D", 0, 1);

    private final String command;
    private final int value;
    private final int index;

    Direction(String command, int value, int index) {
        this.command = command;
        this.value = value;
        this.index = index;
    }

    public String getCommand() {
        return this.command;
    }

    public int getValue() {
        return this.value;
    }

    public int getIndex() {
        return this.index;
    }
}