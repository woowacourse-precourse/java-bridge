package bridge.domain.controller;

import bridge.constants.Direction;
import bridge.constants.MovingPossibility;
import bridge.domain.model.Bridge;
import bridge.domain.model.CrossRecord;
import bridge.domain.model.GameResultInformation;

public class BridgeGame {

    public MovingPossibility move(int space, Direction MOVE_TO) {
        MovingPossibility MOVING_POSSIBILITY = Bridge.checkMovingPossibility(space, MOVE_TO);

        CrossRecord.recordCrossedBridge(MOVE_TO, MOVING_POSSIBILITY);

        return MOVING_POSSIBILITY;
    }

    public void retry() {
        GameResultInformation.increaseCountOfTry();

        CrossRecord.resetCrossedBridge();
    }
}
