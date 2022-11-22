package bridge.model.validator;

import bridge.model.constant.GameCommand;

public class GameCommandValidator implements Validator {
    @Override
    public void validateInput(String input) {
        if (!input.equals(GameCommand.RETRY.getValue()) && !input.equals(GameCommand.QUIT.getValue())) {
            throw new IllegalArgumentException();
        }
    }
}
