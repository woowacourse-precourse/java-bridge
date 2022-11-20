package bridge;


import bridge.data.Direction;
import bridge.data.GameMark;

import java.util.List;

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

    public boolean canMove(String move, List<String> bridge) {
        String cur = bridge.get(position);
        return cur.equals(move);
    }

    private String createMark(String move, List<String> bridge) {
        boolean canMove = canMove(move, bridge);

        if (canMove) {
            return GameMark.O.getMark();
        }
        return GameMark.X.getMark();
    }
}
