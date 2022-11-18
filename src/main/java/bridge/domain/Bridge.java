package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<BridgeBlock> bridge;
    private int bridgeCnt;

    public Bridge(List<BridgeBlock> bridge, int bridgeCnt) {
        this.bridge = bridge;
        this.bridgeCnt = bridgeCnt;
    }

    public boolean isSameBy(String bridgeBlock) {
        return bridgeBlock.equals(bridge.get(bridgeCnt));
    }
}
