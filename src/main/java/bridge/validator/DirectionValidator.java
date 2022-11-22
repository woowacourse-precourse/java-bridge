package bridge.validator;

import bridge.domain.Direction;
import bridge.ErrorMessage;

public class DirectionValidator {

    private final String direction;

    public DirectionValidator(final String direction) {
        validateInput(direction);
        this.direction = direction;
    }

    private void validateInput(final String direction) {
        try {
            Direction.of(direction);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                ErrorMessage.INVALID_DIRECTION
            );
        }
    }

    public String getDirection() {
        return direction;
    }
}
