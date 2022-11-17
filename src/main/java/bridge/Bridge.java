package bridge;

import java.util.List;

public class Bridge {

    public static final int CRITERION_ROUND_START = 1;
    private final List<BridgeMark> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = BridgeMark.of(bridge);
    }

    public GameStatus cross(int round, BridgeMark mark) {
        BridgeMark bridgeMark = bridge.get(round - CRITERION_ROUND_START);
        if (bridgeMark.equals(mark)) {
            return GameStatus.CONTINUE;
        }
        return GameStatus.FAIL;
    }
}
