package bridge.domain;

import bridge.enums.CommandType;

public class PlayerCommand {
    private String command;

    public PlayerCommand(String command) {
        validateCommandType(command);
        this.command = command;
    }

    private void validateCommandType(String command) throws IllegalArgumentException{
        CommandType.selectCommandTypeByInitial(command);
    }

    public String getCommand() {
        return command;
    }
}
