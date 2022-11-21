package bridge.domain;

import static bridge.constant.GameStatus.END;
import static bridge.constant.GameStatus.FAIL;
import static bridge.constant.GameStatus.ON_WAY;

import bridge.constant.GameStatus;
import java.util.List;

public class BridgeMover {
    private List<String> bridge;
    private int location;

    public BridgeMover(List<String> bridge) {
        this.bridge = bridge;
        this.location = 0;
    }

    public GameStatus go(String moving) {
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
        int bridgeSize = this.bridge.size();
        return bridgeSize == location;
    }

    private boolean isCorrect(String moving) {
        String correctMoving = this.bridge.get(this.location);
        return correctMoving.equals(moving);
    }
}
