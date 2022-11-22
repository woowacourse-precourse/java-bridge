package bridge.model;

import java.util.List;

public class Bridge {
    public static final int BRIDGE_SIZE_LOWER_BOUNDS = 3;
    public static final int BRIDGE_SIZE_UPPER_BOUNDS = 20;
    private static final String ERR_BRIDGE_SIZE = "다리 길이는 3 이상 20 이하의 자연수여야 합니다. 예시) 3(O), 18(O), 21(X)";

    private final List<Moving> bridge;

    public Bridge(List<Moving> bridge) {
        this.bridge = bridge;
        validate(bridge);
    }

    private void validate(List<Moving> bridge) {
        if (bridge.size() > BRIDGE_SIZE_UPPER_BOUNDS || bridge.size() < BRIDGE_SIZE_LOWER_BOUNDS) {
            throw new IllegalArgumentException(ERR_BRIDGE_SIZE);
        }
    }

    public PlayerStatus acceptPlayer(int location, Moving choice) {
        if (isCrossed(location, choice)) {
            return PlayerStatus.CROSSED;
        }
        if (isSurviving(location, choice)) {
            return PlayerStatus.MOVING;
        }
        return PlayerStatus.DEAD;
    }

    private boolean isCrossed(int location, Moving choice) {
        return isOverBridge(location) ||
                isLastMovingCorrect(location, choice);
    }

    private boolean isOverBridge(int location) {
        return bridge.size() - 1 < location;
    }

    private boolean isLastMovingCorrect(int location, Moving choice) {
        int lastLocation = bridge.size() - 1;
        return lastLocation == location && bridge.get(lastLocation) == choice;
    }

    private boolean isSurviving(int location, Moving choice) {
        return bridge.get(location) == choice;
    }
}
