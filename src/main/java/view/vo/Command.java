package view.vo;

import constants.CommandTable;
import exception.IllegalArgument;

public class Command {
    private final String command;

    public Command(String commandInput) {
        validateCommandInput(commandInput);
        this.command = commandInput;
    }

    private void validateCommandInput(String commandInput) {
        if (commandInput.equals(CommandTable.RETRY.getInitial())) {
            return;
        }
        if (commandInput.equals(CommandTable.QUIT.getInitial())) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.NOT_COMMAND_INPUT.getMessage());
    }

    public String getCommand() {
        return command;
    }
}


