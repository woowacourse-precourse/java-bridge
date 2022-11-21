package bridge.domain;

import bridge.utils.constants.BridgeMove;

public class BridgePlayer {
    private int currentBridgePosition = BridgeMove.START_INDEX;
    private int gameAttemptCount = 1;
    private final int goStep = BridgeMove.GO_STEP;

    public int getNextBridgePosition(){
        return currentBridgePosition+goStep;
    }

    public void goFront(){
        currentBridgePosition+=goStep;
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
