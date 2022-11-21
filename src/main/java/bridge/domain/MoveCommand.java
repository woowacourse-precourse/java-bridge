package bridge.domain;

import static bridge.domain.BridgeInfo.*;
import static bridge.utils.Constant.WRONG_INSERT_POSITION_MESSAGE;

public class MoveCommand {

    private final String command;
    public MoveCommand(String command) {
        validCommand(command);
        this.command = command;
    }

    private void validCommand(String command) {
        if (!command.equals(BRIDGE_TOP.getHardBridgePosition()) ||
                !command.equals(BRIDGE_BOTTOM.getHardBridgePosition())) {
            throw new IllegalArgumentException(WRONG_INSERT_POSITION_MESSAGE);
        }
    }
}
