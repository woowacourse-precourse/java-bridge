package bridge.model.validator;

import bridge.model.constant.GameCommand;

public class NextMoveValidator implements Validator {
    @Override
    public void validateInput(String input) {
        if (!input.equals(GameCommand.UP.getValue()) && !input.equals(GameCommand.DOWN.getValue())) {
            throw new IllegalArgumentException();
        }
    }
}
