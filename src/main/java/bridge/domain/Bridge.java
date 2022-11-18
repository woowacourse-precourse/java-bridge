package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;

import java.util.List;

public class Bridge {
    private final List<String> bridge;
    
    public Bridge(final BridgeNumberGenerator bridgeNumberGenerator, final int bridgeSize) {
        bridge = new BridgeMaker(bridgeNumberGenerator).makeBridge(bridgeSize);
    }
    
    public boolean isSameWithBridgeSize(final int numberOfMoves) {
        return bridge.size() == numberOfMoves;
    }
    
    public boolean isPartBridgeExist(final int positionToMove, final String moving) {
        return partBridge(positionToMove).equals(moving);
    }
    
    private String partBridge(final int positionToMove) {
        return bridge.get(positionToMove);
    }
    
    @Override
    public String toString() {
        return "Bridge{" +
                "bridge=" + bridge +
                '}';
    }
}
