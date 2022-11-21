package bridge.domain;

import java.util.List;

public class Bridge {
    final List<String> bridge; // U D U U

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    boolean isEndOfBridge(int position) {// bridgeIndex
        if (position == bridge.size()) {
            return true;
        }
        return false;
    }

    boolean isMovable(String moveCommand, int position) { // U 1, D 2 : direction, bridgeIndex
        if (bridge.get(position).equals(moveCommand)) {
            return true;
        }
        return false;
    }

    MoveResult getMoveResult(String moveCommand, int position) {
        if (isMovable(moveCommand, position)) {
            return MoveResult.SUCCESS;
        }
        return MoveResult.FAIL;
    }
}
