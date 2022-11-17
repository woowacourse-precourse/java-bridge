package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private List<String> myAnswerBridges = new ArrayList<>();
    private int attemptCount = 1;

    public void move(Bridge bridge) {
        if (isDroppedBridge(bridge)) {
            myAnswerBridges.add("X");
        }

        myAnswerBridges.add(bridge.getMyMovingPostion());
    }

    private static boolean isDroppedBridge(Bridge bridge) {
        return !bridge.isCorrectBridge();
    }

    public void retry() {
        this.myAnswerBridges.clear();
        this.attemptCount = attemptCount + 1;
    }

    public List<String> getMyAnswerBridges() {
        return myAnswerBridges;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
