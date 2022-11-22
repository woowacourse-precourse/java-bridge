package bridge.domain;

import static bridge.domain.BridgeInfo.BRIDGE_BOTTOM;
import static bridge.domain.BridgeInfo.BRIDGE_TOP;
import static bridge.utils.Constant.WRONG_INSERT_POSITION_MESSAGE;

public class MoveCommand {

    private final String command;

    public MoveCommand(String command) {
        validCommand(command);
        this.command = command;
    }

    private void validCommand(String command) {
        if (!command.equals(BRIDGE_TOP.getPosition()) &&
                !command.equals(BRIDGE_BOTTOM.getPosition())) {
            throw new IllegalArgumentException(WRONG_INSERT_POSITION_MESSAGE);
        }
    }

    public String getCommand() {
        return command;
    }
}
