package bridge.domain;

import static bridge.constant.Commands.DOWN_COMMAND;
import static bridge.constant.Commands.UP_COMMAND;
import static bridge.constant.ExceptionName.BRIDGE_MOVE_EXCEPTION;

public class BridgeMove {

    private final String move;

    public BridgeMove(String move) {
        validateMove(move);
        this.move = move;
    }

    private String validateMove(String move) {
        if (!move.equals(UP_COMMAND) && !move.equals(DOWN_COMMAND)) {
            throw new IllegalArgumentException(BRIDGE_MOVE_EXCEPTION);
        }
        return move;
    }

    public String getMove() {
        return move;
    }
}
