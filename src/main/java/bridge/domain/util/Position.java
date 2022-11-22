package bridge.domain.util;

public enum Position {
    UP("U", 1),
    DOWN("D", 0);

    private final String initial;
    private final int positionNumber;

    Position(String initial, int positionNumber) {
        this.initial = initial;
        this.positionNumber = positionNumber;
    }

    public int getPositionNumber() {
        return positionNumber;
    }

    public String getInitial() {
        return initial;
    }
}
