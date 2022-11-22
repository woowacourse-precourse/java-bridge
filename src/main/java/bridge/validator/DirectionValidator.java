package bridge.validator;

import bridge.domain.Direction;
import bridge.ErrorMessage;

public class DirectionValidator {

    private final Direction direction;

    public DirectionValidator(final String shape) {
        validateInput(shape);
        this.direction = Direction.of(shape);
    }

    private void validateInput(final String shape) {
        try {
            Direction.of(shape);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                ErrorMessage.INVALID_DIRECTION
            );
        }
    }

    public Direction getDirection() {
        return direction;
    }
}
