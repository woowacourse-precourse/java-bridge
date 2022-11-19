package view.vo;

import constants.DirectionTable;
import exception.IllegalArgument;

public class Moving {
    private final String moving;

    public Moving(String movingInput) {
        validateMovingInput(movingInput);
        this.moving = movingInput;
    }

    private void validateMovingInput(String movingInput) {
        if (movingInput.equals(DirectionTable.UP.getInitial())) {
            return;
        }
        if (movingInput.equals(DirectionTable.DOWN.getInitial())) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.NOT_MOVING_INPUT.getMessage());
    }

    public String getMoving() {
        return moving;
    }
}
