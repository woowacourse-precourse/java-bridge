package bridge.model;

import bridge.constant.GameOption;
import bridge.constant.Score;

import java.util.List;

import static bridge.constant.Score.FAIL;
import static bridge.constant.Score.PASS;

public class Referee {

    private final List<String> bridge;
    private int currentRoundNumber;

    public Referee(Bridge bridge) {
        this.bridge = bridge.getBridge();
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
        return isFinalRound() && isPass(moveDirection);
    }

    public Boolean isFinalRound() {
        return bridge.size() == currentRoundNumber;
    }

    public Boolean isPass(String moveDirection) {
        return !isFail(moveDirection);
    }

    public Boolean isGameRestart(String input) {
        GameOption gameOption = GameOption.getGameOptionByMessage(input);
        return gameOption == GameOption.RESTART;
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
}