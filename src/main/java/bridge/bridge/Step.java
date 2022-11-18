package bridge.bridge;

public enum Step {
    MOVABLE("O"),
    IMMOVABLE("X"),
    EMPTY(" "),
    ;

    private final String step;

    Step(String step) {
        this.step = step;
    }

    public String value() {
        return step;
    }
}
