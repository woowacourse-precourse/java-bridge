package bridge.constant;

public enum BridgeMoveCommand {
    MOVE_UP("U"),
    MOVE_DOWN("D");

    private String command;

    BridgeMoveCommand(String command) {
        this.command = command;
    }

    public static BridgeMoveCommand getByOrder(int order) {
        return values()[order];
    }

    public static BridgeMoveCommand getByCommand(String command) {
        for (int i = 0; i < values().length; i++) {
            if (command.equals(values()[i].command)) {
                return values()[i];
            }
        }
        throw InputValidationError.ERROR_COMMAND_MOVE.exception;
    }
}
