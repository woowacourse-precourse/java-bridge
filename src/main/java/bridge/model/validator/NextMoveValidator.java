package bridge.model.validator;

import bridge.model.constant.Direction;

public class NextMoveValidator implements Validator {
    @Override
    public void validateInput(String input) {
        if (!input.equals(Direction.UP.getValue()) && !input.equals(Direction.DOWN.getValue())) {
            throw new IllegalArgumentException();
        }
    }
}
