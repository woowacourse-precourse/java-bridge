package bridge.domain.game;

import bridge.exception.BridgeError;

public class Command {

    private static final String REG_XP_RETRY_COMMAND = "[RQ]+";
    private static final String EXIT = "Q";
    private static final int COMMAND_SIZE = 1;

    private final String command;

    public Command(String command) {
        validate(command);
        this.command = command;
    }

    private void validate(String command) {
        validateCommandForm(command);
        validateCommandSize(command);
    }

    private void validateCommandForm(String command) {
        if (!command.matches(REG_XP_RETRY_COMMAND)) {
            throw new IllegalArgumentException(BridgeError.COMMAND_FORM.message());
        }
    }

    private void validateCommandSize(String command) {
        if (command.length() != COMMAND_SIZE) {
            throw new IllegalArgumentException(BridgeError.COMMAND_SIZE.message());
        }
    }

    public boolean isExitCommand() {
        return command.equals(EXIT);
    }
}
