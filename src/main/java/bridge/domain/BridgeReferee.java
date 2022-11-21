package bridge.domain;

import static bridge.constant.GameStatus.END;
import static bridge.constant.GameStatus.FAIL;
import static bridge.constant.GameStatus.ON_WAY;

import bridge.constant.GameStatus;
import java.util.List;

public class BridgeReferee {
    private final List<String> bridge;
    private int location;

    public BridgeReferee(List<String> bridge) {
        this.bridge = bridge;
        resetLocation();
    }

    public GameStatus judge(String moving) {
        if (isCorrect(moving)) {
            this.location += 1;
            if (isCrossCompletely()) {
                return END;
            }
            return ON_WAY;
        }
        return FAIL;
    }

    public boolean isCrossCompletely() {
        int bridgeSize = bridge.size();
        return bridgeSize == location;
    }

    public void resetLocation() {
        this.location = 0;
    }

    private boolean isCorrect(String moving) {
        String correctMoving = bridge.get(location);
        return correctMoving.equals(moving);
    }
}
