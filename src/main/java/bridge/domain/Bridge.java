package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(int bridgeSize, BridgeMaker bridgeMaker) {
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    public boolean canGo(int position, String spaceToMove) {
        return bridge.get(position).equals(spaceToMove);
    }
}
