package bridge.domain;

import static bridge.util.Messages.*;

public class CompareBridge {

    private final String move;

    public CompareBridge(String move) {
        this.move = move;
    }

    public CompareBridge getUpSideMove(CompareBridge playerMove, String bridgeElement) {
        if (playerMove.move.equals(DOWN_DIRECTION)) {
            return new CompareBridge(WHITESPACE);
        }
        if (playerMove.move.equals(bridgeElement)) {
            return new CompareBridge(CORRECT);
        }
        return new CompareBridge(INCORRECT);
    }

    public CompareBridge getDownSideMove(CompareBridge playerMove, String bridgeElement) {
        if (playerMove.move.equals(UP_DIRECTION)) {
            return new CompareBridge(WHITESPACE);
        }
        if (playerMove.move.equals(bridgeElement)) {
            return new CompareBridge(CORRECT);
        }
        return new CompareBridge(INCORRECT);
    }

    @Override
    public String toString() {
        return move.toString() + VERTICAL_BAR;
    }
}
