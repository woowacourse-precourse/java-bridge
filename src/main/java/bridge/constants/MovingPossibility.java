package bridge.constants;

public enum MovingPossibility {
    CAN_MOVE("O"),
    CAN_NOT_MOVE("X");

    private final String character;

    MovingPossibility(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return this.character;
    }
}
