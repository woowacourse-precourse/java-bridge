package bridge.command;

import bridge.exception.BridgeGameError;

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

    public static MoveCommand setMoveCommand(String str) {
        if (str.equals("U")) {
            return MoveCommand.UP;
        }
        if (str.equals("D")) {
            return MoveCommand.DOWN;
        }
        throw new IllegalArgumentException(BridgeGameError.INVALID_TYPE_MOVE_COMMAND.getErrorMessage());
    }

    public static MoveCommand setCommandByNumber(int number) {
        if (number == 1) {
            return MoveCommand.UP;
        }
        if (number == 0) {
            return MoveCommand.DOWN;
        }
        throw new IllegalArgumentException(BridgeGameError.INVALID_TYPE_START_PLAY_COMMAND.getErrorMessage());
    }
}
