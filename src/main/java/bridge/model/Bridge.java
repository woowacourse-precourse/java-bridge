package bridge.model;

import bridge.constant.GameOption;
import bridge.constant.Score;

import java.util.Collections;
import java.util.List;

import static bridge.constant.Score.FAIL;
import static bridge.constant.Score.PASS;

public class Bridge {

    private final List<String> bridge;
    private int currentRoundNumber;

    public Bridge (List<String> bridge) {
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
        String validBridge = bridge.get(index);
        return !validBridge.equals(moveDirection);
    }

    public Boolean isFinalRoundPass(String moveDirection) {
        Boolean isFinalRound = bridge.size() == currentRoundNumber;
        Boolean isPass = !isFail(moveDirection);
        return isFinalRound && isPass;
    }

    public void addCurrentRoundNumber() {
        currentRoundNumber +=1 ;
    }

    public void resetCurrentRoundNumber() {
        currentRoundNumber = 0;
    }

    public int getCurrentRoundNumber() {
        return currentRoundNumber;
    }

    public List<String> getBridge () {
        return Collections.unmodifiableList(bridge);
    }

    public Boolean isRoundLeft(int currentRoundNumber) {
        int finalRound = bridge.size();
        return currentRoundNumber < finalRound;
    }
}