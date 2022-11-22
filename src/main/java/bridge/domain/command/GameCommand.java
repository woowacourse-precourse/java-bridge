package bridge.domain.command;

import bridge.domain.exception.NotExistCommandException;

import bridge.utils.Constants;

import java.util.Objects;

public class GameCommand {

    private final String gameCommand;

    private GameCommand(String input) {
        if (!isValidateRange(input)) {
            throw new NotExistCommandException();
        }

        gameCommand = input;
    }

    private boolean isValidateRange(String input) {
        return Objects.equals(input, Constants.RESTART) || Objects.equals(input,
            Constants.QUIT);
    }

    public static GameCommand from(String gameCommand) {
        return new GameCommand(gameCommand);
    }

    public String getGameCommand() {
        return gameCommand;
    }
}
