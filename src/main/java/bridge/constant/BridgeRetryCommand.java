package bridge.constant;

public enum BridgeRetryCommand {
    RETRY("R"),
    QUIT("Q");

    public final String command;

    BridgeRetryCommand(String command) {
        this.command = command;
    }

    public static BridgeRetryCommand getByCommand(String command) {
        for (int i = 0; i < values().length; i++) {
            if (command.equals(values()[i].command)) {
                return values()[i];
            }
        }
        throw InputValidationError.ERROR_COMMAND_RETRY.exception;
    }
}
