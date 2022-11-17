package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.constant.GameKeyboard.WRONG_ANSWER;

public class BridgeGame {
    public static final int PLUS_COUNT = 1;
    private List<String> myAnswerBridges = new ArrayList<>();
    private int attemptCount = 1;

    public void move(Bridge bridge) {
        if (isDroppedBridge(bridge)) {
            myAnswerBridges.add(WRONG_ANSWER.letter());
        }

        myAnswerBridges.add(bridge.getMyMovingPostion());
    }

    private static boolean isDroppedBridge(Bridge bridge) {
        return !bridge.isCorrectBridge();
    }

    public void retry() {
        this.myAnswerBridges.clear();
        this.attemptCount = attemptCount + PLUS_COUNT;
    }

    public List<String> getMyAnswerBridges() {
        return myAnswerBridges;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
