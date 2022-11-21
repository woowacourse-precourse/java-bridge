package bridge;

import bridge.constant.BridgeMark;
import bridge.constant.GameStatus;

import java.util.List;

public class Bridge {

    private static final int CRITERION_ROUND_START = 1;

    private final List<BridgeMark> bridge;

    public Bridge(List<String> bridge) {
        BridgeValidUtil.validateSize(bridge.size());
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
