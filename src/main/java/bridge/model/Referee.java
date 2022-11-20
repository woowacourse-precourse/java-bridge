package bridge.model;

import bridge.constant.Score;

import java.util.List;

import static bridge.constant.Score.FAIL;
import static bridge.constant.Score.PASS;

public class Referee {

    private final List<String> bridge;
    private final int currentRoundNumber;

    public Referee(Bridge bridge, int currentRoundNumber) {
        this.bridge = bridge.getBridge();
        this.currentRoundNumber = currentRoundNumber;
    }

    public Score judgeMove(String moveDirection) {
        if (isFail(moveDirection)) {
            return FAIL;
        }
        return PASS;
    }

    public Boolean isFail(String moveDirection) {
        int index = currentRoundNumber - 1;
        String validBridge = bridge.get(index);
        return !validBridge.equals(moveDirection);
    }
}