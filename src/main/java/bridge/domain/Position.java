package bridge.domain;

public class Position {

    private static final int INCREASE_AMOUNT = 1;
    private static final int POSITION_MINIMUM = 0;
    private static final String NEGATIVE_POSITION_EXCEPTION_MESSAGE = "위치는 음수일 수 없습니다";

    private final int position;

    public Position() {
        this(POSITION_MINIMUM);
    }

    Position(int position) {
        validateRange(position);
        this.position = position;
    }

    private void validateRange(int position) {
        if (position < POSITION_MINIMUM) {
            throw new IllegalArgumentException(NEGATIVE_POSITION_EXCEPTION_MESSAGE);
        }
    }

    public Position increase() {
        return new Position(position + INCREASE_AMOUNT);
    }

    public boolean isGreaterOrEqualThan(int position) {
        return this.position >= position;
    }
}
