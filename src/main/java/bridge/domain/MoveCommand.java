package bridge.domain;

import bridge.exception.BridgeGameError;
import bridge.exception.CommandException;

public enum MoveCommand {
    UP("U"),
    DOWN("D");

    private final String command;

    MoveCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static MoveCommand setCommandByNumber(int number) {
        if (number == 1) {
            return MoveCommand.UP;
        }
        if (number == 0) {
            return MoveCommand.DOWN;
        }
        throw new CommandException(BridgeGameError.NOT_ZERO_OR_ONE);
    }

    public static MoveCommand setCommand(String input) {
        if (input.equals("U")) {
            return MoveCommand.UP;
        }
        if (input.equals("D")) {
            return MoveCommand.DOWN;
        }
        throw new CommandException(BridgeGameError.INVALID_MOVE_COMMAND_INPUT);
    }
}
