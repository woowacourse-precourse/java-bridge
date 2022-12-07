package bridge.model;

import bridge.constant.Score;

import static bridge.constant.Score.FAIL;
import static bridge.constant.Score.PASS;

public class BridgePosition {

    private final Bridge bridge;
    private int currentRoundNumber;

    public BridgePosition (Bridge bridge) {
        this.bridge = bridge;
        currentRoundNumber = 0;
    }

    public Score judgeMove(String moveDirection) {
        if (isFail(moveDirection)) {
            return FAIL;
        }
        return PASS;
    }

    public Boolean isFail(String moveDirection) {
        int index = currentRoundNumber - 1;
        return !bridge.isExist(index, moveDirection);
    }

    public void addCurrentRoundNumber() {
        currentRoundNumber +=1 ;
    }

    public void resetCurrentRoundNumber() {
        currentRoundNumber = 0;
    }

    public Boolean isRoundLeft() {
        int finalRound = bridge.getSize();
        return currentRoundNumber < finalRound;
    }
}
