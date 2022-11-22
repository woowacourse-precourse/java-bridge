package bridge.domain;

import bridge.domain.constant.ExceptionMessage;

import java.util.Objects;

public class Moving {
    private final String moving;

    private Moving(String moving) {
        this.moving = moving;
    }

    public static Moving createMoving(String inputMoving) {
        validateNullInput(inputMoving);
        validateMoving(inputMoving);
        return new Moving(inputMoving);
    }

    private static void validateMoving(String moving) {
        if (!isUpOrDown(moving)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_UP_OR_DOWN);
        }
    }

    private static boolean isUpOrDown(String moving) {
        return moving.equals(MovingStatus.UP.getMovingKey())
                || moving.equals(MovingStatus.DOWN.getMovingKey());
    }

    private static void validateNullInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.NULL_INPUT);
        }
    }

    @Override
    public String toString() {
        return moving;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Moving moving1 = (Moving) o;
        return Objects.equals(moving, moving1.moving);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moving);
    }
}
