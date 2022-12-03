package bridge.domain;

import bridge.utils.constants.PlayerPosition;

public class BridgePlayer {
    private int currentBridgePosition = PlayerPosition.START_INDEX.getValue();
    private int gameAttemptCount = 1;

    public void goFront(){
        currentBridgePosition+=PlayerPosition.GO_FRONT_STEP.getValue();
    }

    public void initializePlayerPosition(){
        this.currentBridgePosition = PlayerPosition.START_INDEX.getValue();
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
