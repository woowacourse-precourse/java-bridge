package bridge;

import constants.BridgeConstants;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public String isCorrectMoving(String moving, int round) {
        if (bridge.get(round).equals(moving)) {
            return BridgeConstants.RIGHT_ANSWER;
        }
        return BridgeConstants.WRONG_ANSWER;
    }
}
