package bridge.domain;

import static bridge.constant.GameStatus.END;
import static bridge.constant.GameStatus.FAIL;
import static bridge.constant.GameStatus.ON_WAY;

import bridge.constant.GameStatus;
import java.util.List;

public class BridgeReferee {
    private List<String> bridge;
    private int location;

    public BridgeReferee(List<String> bridge) {
        this.bridge = bridge;
        this.location = 0;
    }

    public GameStatus judge(String moving) {
        if (!isCorrect(moving)) {
            return FAIL;
        }
        this.location += 1;
        if (isCrossCompletely()) {
            return END;
        }
        return ON_WAY;
    }

    public boolean isCrossCompletely() {
        int bridgeSize = bridge.size();
        return bridgeSize == location;
    }

    private boolean isCorrect(String moving) {
        String correctMoving = bridge.get(location);
        return correctMoving.equals(moving);
    }
}
