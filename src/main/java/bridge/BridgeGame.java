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

    public void move(String move, List<String> bridge, PlayerMap playerMap) {
        String mark = createMark(move, bridge);
        Direction direction = createDirection(move);

        playerMap.move(direction, position, mark);
        position++;
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

    public void resetPrev(PlayerMap playerMap) {
        position--;
        playerMap.resetPrev(position);
    }
}
