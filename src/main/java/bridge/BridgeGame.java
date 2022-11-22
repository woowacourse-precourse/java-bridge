package bridge;

import static bridge.Cross.canNotCross;
import static bridge.controller.InputController.getMoving;

public class BridgeGame {

    private final Bridge bridge;
    private final Map map;
    private Cross cross;

    public BridgeGame(Bridge bridge, Map map) {
        this.bridge = bridge;
        this.map = map;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public int move() {
        int index;
        for (index = 0; index < bridge.getBridgeSize(); index++) {
            moveByIndex(index);
            if (canNotCross(cross)) {
                break;
            }
        }
        return index;
    }

    private void moveByIndex(int index) {
        Moving moving = getMoving();

        cross = Cross.from(bridge.isSameMoving(index, moving));

        map.update(moving, cross);

        map.print();
    }

    public void retry() {
    }
}
