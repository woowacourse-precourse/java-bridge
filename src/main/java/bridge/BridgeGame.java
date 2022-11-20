package bridge;


import bridge.data.Direction;

import static bridge.data.Direction.DOWN_DIRECTION;
import static bridge.data.Direction.UP_DIRECTION;
import static bridge.data.GameCommand.UP;

public class BridgeGame {

    private int position;

    public BridgeGame() {
        position = 0;
    }

    public void move() {
    }

    public void retry() {
    }

    private Direction createDirection(String move) {
        if (move.equals(UP.getCommand())) {
            return UP_DIRECTION;
        }
        return DOWN_DIRECTION;
    }
}
