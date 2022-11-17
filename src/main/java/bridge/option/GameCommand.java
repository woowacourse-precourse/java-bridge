package bridge.option;

import static bridge.config.ExceptionMessage.WRONG_GAME_OPTION;

public class GameCommand {
    private static final String RESTART = "R";
    private static final String END = "Q";

    private final String gameCommand;

    public GameCommand(String gameCommand) {
        Option.validate(gameCommand);
        validate(gameCommand);
        this.gameCommand = gameCommand;
    }

    private void validate(String gameCommand) {
        validateOptionAvailable(gameCommand);
    }

    private void validateOptionAvailable(String gameCommand) {
        if (!gameCommand.equals(RESTART) && !gameCommand.equals(END)) {
            throw new IllegalArgumentException(WRONG_GAME_OPTION.toString());
        }
    }
}
