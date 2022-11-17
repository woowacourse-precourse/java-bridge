package bridge.domain;

import bridge.constant.Constant;
import bridge.constant.ErrorMessage;

public class Command {
    private final String command;

    public Command(String command) {
        validCommand(command);
        this.command = command;
    }

    private void validCommand(String command) {
        if (!command.equals(Constant.RETRY) && !command.equals(Constant.QUIT)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_COMMAND_VALUE.getMessage());
        }
    }

    public boolean isRetry() {
        if (command.equals(Constant.RETRY)) {
            return true;
        }
        return false;
    }
}
