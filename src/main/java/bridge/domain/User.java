package bridge.domain;

import bridge.utils.command.MoveCommand;

import static bridge.utils.message.ErrorMessage.INVALID_MOVING_COMMAND;

public class User {
    
    private int step = 0;
    private boolean live = true;

    public void init() {
        this.step = 0;
        this.live = true;
    }

    public void move(Bridge bridge, String input) {
        validateCommand(input);
        if (!bridge.isSafe(step, input)) {
            live = false;
            return;
        }
        step++;
    }

    private void validateCommand(String input) {
        if (!MoveCommand.contains(input)) {
            throw new IllegalArgumentException(INVALID_MOVING_COMMAND.getMessage());
        }
    }

    public int getStep() {
        return this.step;
    }

    public boolean isLive() {
        return this.live;
    }

}
