package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class GameRound {
    private static final String MOVING_COMMAND_UP = "U";
    private static final String MOVING_COMMAND_DOWN = "D";
    private static final String CORRECT_POSITION = "O";
    private static final String UNCORRECT_POSITION = "X";
    private static final String BLANK = " ";

    private List<List<String>> playedBridge;
    private int bridgeIndex;
    private boolean isWin;

    public GameRound() {
        playedBridge = new ArrayList<>();
        List<String> upperBridge = new ArrayList<>();
        List<String> lowerBridge = new ArrayList<>();
        playedBridge.add(upperBridge);
        playedBridge.add(lowerBridge);

        bridgeIndex = 0;
        isWin = false;
    }

    public List<List<String>> getPlayedBridge() {
        return playedBridge;
    }

    public int getBridgeIndex() {
        return bridgeIndex;
    }

    public void setBridgeIndex(int bridgeIndex) {
        this.bridgeIndex = bridgeIndex;
    }

    public boolean getIsWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public void recordResult(String movingCommand, String nowBridgePosition) {
        if (isCorrect(movingCommand, nowBridgePosition)) {
            checkCorrectPosition(movingCommand);
            return;
        }
        checkUnCorrectPosition(movingCommand);
    }

    private void checkCorrectPosition(String movingCommand) {
        if(movingCommand.equals(MOVING_COMMAND_UP)) {
            recordUpperCorrect();
            return;
        }
        recordLowerCorrect();
    }

    private void checkUnCorrectPosition(String movingCommand) {
        if (movingCommand.equals(MOVING_COMMAND_UP)) {
            recordUpperUncorrect();
            return;
        }
        recordLowerUncorrect();
    }

    private boolean isCorrect(String movingCommand, String nowBridgePosition) {
        if (movingCommand.equals(nowBridgePosition)) {
            return true;
        }
        return false;
    }

    private void recordUpperCorrect() {
        playedBridge.get(0).add(CORRECT_POSITION);
        playedBridge.get(1).add(BLANK);
    }

    private void recordLowerCorrect() {
        playedBridge.get(1).add(CORRECT_POSITION);
        playedBridge.get(0).add(BLANK);
    }

    private void recordUpperUncorrect() {
        playedBridge.get(0).add(UNCORRECT_POSITION);
        playedBridge.get(1).add(BLANK);
    }

    private void recordLowerUncorrect() {
        playedBridge.get(1).add(UNCORRECT_POSITION);
        playedBridge.get(0).add(BLANK);
    }

}
