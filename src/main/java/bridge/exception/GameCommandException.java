package bridge.exception;

import bridge.service.UserInput;

public class GameCommandException extends UserException {
    @Override
    public void checkException(String userInput) {
        isEmpty(userInput);
        isBlank(userInput);
        hasBlank(userInput);
        isNotGameCommand(userInput);
    }

    private void isNotGameCommand(String gameCommand) {
        if (!UserInput.GAME_COMMAND.getLetters().contains(gameCommand)) {
            throw new IllegalArgumentException(ExceptionCode.IS_NOT_GAME_COMMAND.getMessage());
        }
    }
}
