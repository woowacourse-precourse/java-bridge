package bridge.domain;

import bridge.constant.ErrorMessage;

public class Command {
    private final String command;

    public Command(String command) {
        validateType(command);
        this.command = command;
    }

    private void validateType(String command) {
        if (!command.matches("[RQ]")) {
            throw new IllegalArgumentException(ErrorMessage.COMMAND_TYPE.getMessage());
        }
    }

    public String getCommand() {
        return command;
    }
}
