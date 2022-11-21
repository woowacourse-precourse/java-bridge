package bridge;

import java.util.List;

public class Move {
    private static final int START = 0;

    private final List<String> bridge;
    private int countNumberOfMove;

    Move(List<String> bridge) {
        this.bridge = bridge;
        init();
    }

    private void init() {
        countNumberOfMove = START;
    }

    public boolean canMove(String moveDirection) {
        if (bridge.get(countNumberOfMove++) == moveDirection) {
            return true;
        }
        return false;
    }

    public boolean isPassBridge() {
        if (bridge.size() == countNumberOfMove) {
            return true;
        }
        return false;
    }
}
