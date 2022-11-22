package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> bridgeBlocks;

    public Bridge(List<String> bridgeBlocks) {
        this.bridgeBlocks = bridgeBlocks;
    }

    public boolean isMovable(String bridgePosition, int order) {
        return bridgeBlocks.get(order).equals(bridgePosition);
    }

    public boolean isEndPoint(int order) {
        return bridgeBlocks.size() == order;
    }
}
