package bridge.domain;

import bridge.utils.command.MoveCommand;

import static bridge.utils.message.ErrorMessage.INVALID_INPUT_VALUE;

public class Floor {

    private final String command;

    Floor(String command) {
        validateCommand(command);
        this.command = command;
    }

    private void validateCommand(String command) {
        if (!MoveCommand.contains(command)) {
            throw new IllegalArgumentException(INVALID_INPUT_VALUE.getMessage());
        }
    }

    public boolean isSafe(String input) {
        validateCommand(input);
        return this.command.equals(input);
    }
    
}
