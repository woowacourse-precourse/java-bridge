package bridge.dto;

import bridge.domain.command.Command;

public class MoveResult {

    private Command command;
    private boolean success;
    private int round;

    public String getMessage() {
        return command.getMessage();
    }

    public boolean isSuccess() {
        return success;
    }

    public int getRound() {
        return round;
    }

    public MoveResult(Command command, boolean success, int round) {
        this.command = command;
        this.success = success;
        this.round = round;
    }
}
