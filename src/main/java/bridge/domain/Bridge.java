package bridge.domain;

import bridge.domain.factory.BridgeMaker;
import bridge.domain.strategy.BridgeNumberGenerator;

import java.util.List;

public class Bridge {
    private final List<String> bridge;
    
    public Bridge(final BridgeNumberGenerator bridgeNumberGenerator, final int bridgeSize) {
        bridge = new BridgeMaker(bridgeNumberGenerator).makeBridge(bridgeSize);
    }
    
    public boolean isSameWithBridgeSize(final int numberOfMoves) {
        return bridge.size() == numberOfMoves;
    }
    
    public boolean isPartBridgeExist(final int currentPosition, final String moving) {
        return partBridge(currentPosition).equals(moving);
    }
    
    private String partBridge(final int currentPosition) {
        return bridge.get(currentPosition);
    }
    
    @Override
    public String toString() {
        return "Bridge{" +
                "bridge=" + bridge +
                '}';
    }
}
