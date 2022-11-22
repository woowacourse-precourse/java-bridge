package bridge.domain;

import bridge.utils.constants.BridgeMove;

public class BridgePlayer {
    private int currentBridgePosition = BridgeMove.START_INDEX;
    private int gameAttemptCount = 1;

    public void goFront(){
        currentBridgePosition+=BridgeMove.GO_STEP;
    }

    public void initializePlayerPosition(){
        this.currentBridgePosition = BridgeMove.START_INDEX;
    }

    public void increaseAttemptCount(){
        gameAttemptCount+=1;
    }

    public int getCurrentBridgePosition(){
        return currentBridgePosition;
    }

    public int getGameAttemptCount(){
        return gameAttemptCount;
    }
}
