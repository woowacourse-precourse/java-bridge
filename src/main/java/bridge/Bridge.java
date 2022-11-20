package bridge;

import bridge.constant.BridgeMark;
import bridge.constant.GameStatus;

import java.util.List;

public class Bridge {

    public static final int CRITERION_ROUND_START = 1;
    public static final String ERROR_OUT_RANGE_LENGTH = "[ERROR] 다리의 길이는 3이상 20이하이어야 합니다.";
    public static final int MINIMUM_LENGTH = 3;
    public static final int MAXIMUM_LENGTH = 20;

    private final List<BridgeMark> bridge;

    public Bridge(List<String> bridge) {
        validateRange(bridge);
        this.bridge = BridgeMark.of(bridge);
    }

    private void validateRange(List<String> bridge) {
        if (isOutRange(bridge)) {
            throw new IllegalArgumentException(ERROR_OUT_RANGE_LENGTH);
        }
    }

    private boolean isOutRange(List<String> bridge) {
        return (bridge.size() < MINIMUM_LENGTH) || (bridge.size() > MAXIMUM_LENGTH);
    }

    public GameStatus cross(int round, BridgeMark playerMark) {
        BridgeMark bridgeMark = get(round);

        if (bridgeMark.equals(playerMark) && isLastRound(round)) {
            return GameStatus.SUCCESS;
        }
        if (bridgeMark.equals(playerMark)) {
            return GameStatus.CONTINUE;
        }
        return GameStatus.FAIL;
    }

    private BridgeMark get(int round) {
        return bridge.get(round - CRITERION_ROUND_START);
    }

    private boolean isLastRound(int round) {
        return bridge.size() == round;
    }
}
