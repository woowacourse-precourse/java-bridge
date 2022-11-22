package bridge;

import java.util.List;

public class MoveCheck {

    private final List<String> bridge;

    public MoveCheck(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean checkIfAvailableToMove(int moveValue, String readMoving) {
        if (bridge.get(moveValue).equals(readMoving)) {
            return true;
        }
        return false;
    }
}
