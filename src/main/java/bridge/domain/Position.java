package bridge.domain;

public class Position {

    private final int value;

    public Position(int value) {
        this.value = value;
    }

    Position increase() {
        return new Position(value + 1);
    }

    Position reset() {
        return new Position(0);
    }

    boolean isLessThan(int size) {
        return value < size;
    }

    int value() {
        return value;
    }
}
