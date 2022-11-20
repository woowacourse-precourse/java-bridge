package bridge;

public enum MovingResult {
    POSSIBLE("O", true),
    IMPOSSIBLE("X", false);

    private final String side;
    private final boolean possibility;

    MovingResult(String side, boolean possibility) {
        this.side = side;
        this.possibility = possibility;
    }
}
