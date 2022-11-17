package bridge;

import java.util.List;

public class Bridge {

    public static final int CRITERION_ROUND_START = 1;
    public static final int MINIMUM_LENGTH = 3;
    public static final String ERROR_INVALID_MINIMUM_LENGTH = "[ERROR] 다리의 길이는 3이상 20이하이어야 합니다.";

    private final List<BridgeMark> bridge;

    public Bridge(List<String> bridge) {
        if (bridge.size() < MINIMUM_LENGTH) {
            throw new IllegalArgumentException(ERROR_INVALID_MINIMUM_LENGTH);
        }
        this.bridge = BridgeMark.of(bridge);
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
