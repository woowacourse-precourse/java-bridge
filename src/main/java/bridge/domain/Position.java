package bridge.domain;

public class Position {

    private static final int INCREASE_AMOUNT = 1;

    private final int position;

    public Position() {
        this(0);
    }

    private Position(int position) {
        this.position = position;
    }

    public Position increase() {
        return new Position(position + INCREASE_AMOUNT);
    }

    public boolean isGreaterOrEqualThan(int position) {
        return this.position >= position;
    }
}
