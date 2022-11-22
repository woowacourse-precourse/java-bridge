package bridge;

import static bridge.Cross.canNotCross;
import static bridge.GameCommand.isRetry;
import static bridge.controller.GameController.addAttempt;
import static bridge.controller.InputController.getMoving;

import bridge.controller.GameController;

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

    public Cross getCross() {
        return cross;
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

        updateMap(moving);

        printMap();
    }

    private void updateMap(Moving moving) {
        map.update(moving, cross);
    }

    private void printMap() {
        map.print();
    }

    public void retry(GameCommand userCommand) {
        if (isRetry(userCommand)) {
            addAttempt();

            GameController.setRetry();
            return;
        }
        GameController.setQuit();
    }
}
