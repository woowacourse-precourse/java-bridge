package bridge.bridge;

public enum Moving {
    MOVABLE("O"),
    IMMOVABLE("X"),
    EMPTY(" "),
    ;

    private final String moving;

    Moving(String moving) {
        this.moving = moving;
    }

    public String moving() {
        return moving;
    }
}
