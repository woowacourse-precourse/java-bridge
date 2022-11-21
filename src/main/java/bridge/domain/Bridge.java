package bridge.domain;

import java.util.List;

public class Bridge {
    private List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    boolean matchWithIndex(int idx, String candidate) {
        return bridge.get(idx).equals(candidate);
    }

    boolean isFinish(int idx) {
        return bridge.size() - 1 == idx;
    }

    public BridgeState getStateOf(int idx, String candidate) {
        if (matchWithIndex(idx, candidate)) {
            return BridgeState.CORRECT;
        }
        return BridgeState.WRONG;
    }
}
