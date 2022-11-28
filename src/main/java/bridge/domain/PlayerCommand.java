package bridge.domain;

import bridge.enums.CommandType;

public class PlayerCommand {
    private String command;

    public PlayerCommand(String input) {
        input = input.strip();
        validateCommandType(input);
        this.command = input;
    }

    private void validateCommandType(String command) throws IllegalArgumentException{
        CommandType.selectCommandTypeByInitial(command);
    }

    public String getCommand() {
        return command;
    }
}
