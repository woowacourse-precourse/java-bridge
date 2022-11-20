package bridge.domain.bridge;

import java.util.List;

public class Bridge {

    private final List<BridgeBlock> bridge;

    public Bridge(List<BridgeBlock> bridge) {
        this.bridge = bridge;
    }

    public boolean isSameBy(BridgeBlock bridgeBlock, Phase phase) {
        return bridgeBlock.equals(this.bridge.get(phase.getCurrentPhase()));
    }

    public int size() {
        return bridge.size();
    }
}
