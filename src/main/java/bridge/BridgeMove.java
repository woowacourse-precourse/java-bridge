package bridge;

import static bridge.exception.ExceptionName.BRIDGE_MOVE_EXCEPTION;

public class BridgeMove {

    private final String move;

    public BridgeMove(String move) {
        validateMove(move);
        this.move = move;
    }

    private String validateMove(String move) {
        if (!move.equals("U") && !move.equals("D")) {
            throw new IllegalArgumentException(BRIDGE_MOVE_EXCEPTION);
        }
        return move;
    }

    public String getMove() {
        return move;
    }
}
