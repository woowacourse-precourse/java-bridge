package bridge.model.validator;

import bridge.model.GameCommand;

public class GameCommandValidator implements Validator{
    @Override
    public void validateInput(String input) {
        if (!input.equals(GameCommand.RETRY.getValue()) && !input.equals(GameCommand.QUIT.getValue())) {
            throw new IllegalArgumentException();
        }
    }
}
