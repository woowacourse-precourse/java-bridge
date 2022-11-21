package bridge.domain;

import bridge.utils.constants.BridgeMove;

public class BridgePlayer {
    private int currentBridgePosition = BridgeMove.START_INDEX;
    private int gameAttemptCount = 0;

    public int getNextBridgePosition(){
        return currentBridgePosition+BridgeMove.GO_STEP;
    }
}
