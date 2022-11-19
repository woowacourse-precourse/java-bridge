package bridge.domain;

import bridge.domain.command.Command;

public class MoveResult {

    private Command command;
    private boolean success;

    public String getMessage() {
        return command.getMessage();
    }

    public boolean isSuccess() {
        return success;
    }

    public MoveResult(Command command, boolean success) {
        this.command = command;
        this.success = success;
    }
}
