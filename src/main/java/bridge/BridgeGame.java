package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.constant.GameKeyboard.WRONG_ANSWER;

public class BridgeGame {
    private List<String> myAnswerBridges;
    private AttemptCount attemptCount;

    public BridgeGame() {
        this.myAnswerBridges = new ArrayList<>();
        this.attemptCount = new AttemptCount();
    }

    public void move(Bridge bridge) {
        if (isDroppedBridge(bridge)) {
            myAnswerBridges.add(WRONG_ANSWER.letter());
        }

        myAnswerBridges.add(bridge.getMyMovingPosition());
    }

    private static boolean isDroppedBridge(Bridge bridge) {
        return !bridge.isCorrectBridge();
    }

    public void retry() {
        this.myAnswerBridges.clear();
        this.attemptCount = attemptCount.plus();
    }

    public boolean isSelectedCorrectBridge() {
        return !myAnswerBridges.contains(WRONG_ANSWER.letter());
    }

    public boolean isSelectedWrongBridge() {
        return myAnswerBridges.contains(WRONG_ANSWER.letter());
    }

    public String getWrongMovingMark(int currentBridgeIndex) {
        return myAnswerBridges.get(currentBridgeIndex + 1);
    }

    public String getCorrectMovingMark(int currentBridgeIndex) {
        return myAnswerBridges.get(currentBridgeIndex);
    }

    public List<String> getMyAnswerBridges() {
        return myAnswerBridges;
    }

    public AttemptCount getAttemptCount() {
        return attemptCount;
    }
}
