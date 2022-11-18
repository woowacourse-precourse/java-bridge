package bridge.constant;

public enum Movement {
    UP_AND_O("U", 'O'),
    UP_AND_X("U", 'X'),
    DOWN_AND_O("D", 'O'),
    DOWN_AND_X("D", 'X');

    private final String direction;
    private final char moveable;

    Movement(String direction, char moveable) {
        this.direction = direction;
        this.moveable = moveable;
    }

    public String direction() {
        return direction;
    }

    public char moveable() {
        return moveable;
    }

    public boolean isAvailable() {
        return moveable == 'O';
    }
}
