package bridge.command;

import static bridge.config.ExceptionMessage.WRONG_GAME_OPTION;

import bridge.command.enums.GameCommand;

public class Command {

    private final String command;

    public Command(String command) {
        Option.validate(command);
        validate(command);
        this.command = command;
    }

    private void validate(String command) {
        validateOptionAvailable(command);
    }

    private void validateOptionAvailable(String command) {
        if (!GameCommand.isInGameCommand(command)) {
            throw new IllegalArgumentException(WRONG_GAME_OPTION.toString());
        }
    }

    public String getCommand() {
        return command;
    }
}
