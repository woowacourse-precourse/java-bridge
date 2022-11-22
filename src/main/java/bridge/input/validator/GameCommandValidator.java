package bridge.input.validator;

import bridge.constant.GameCommand;

public class GameCommandValidator {
    private static final String RETRY = GameCommand.RETRY.getValue();
    private static final String QUIT = GameCommand.QUIT.getValue();

    public boolean isValidGameCommand(String userInputForGameCommand) {
        return userInputForGameCommand.equals(RETRY)
                || userInputForGameCommand.equals(QUIT);
    }
}
