package bridge.domain;

import bridge.constant.Constant;
import bridge.constant.ErrorMessage;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(command);
    }

    @Override
    public boolean equals(Object obj) {
        if (command.equals(obj)) {
            return true;
        }
        return false;
    }
}
