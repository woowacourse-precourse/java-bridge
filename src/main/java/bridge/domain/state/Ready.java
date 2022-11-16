package bridge.domain.state;

import bridge.domain.MoveResult;
import bridge.domain.constants.BridgeConstants;

import java.util.List;

public class Ready implements State {
    private final List<String> bridge;
    
    public Ready(final List<String> bridge) {
        this.bridge = bridge;
    }
    
    @Override
    public MoveResult state() {
        return MoveResult.READY;
    }
    
    @Override
    public State move(final int currentPosition) {
        if (isPartBridgeExist(currentPosition)) {
            return new Success();
        }
        
        return new Fail();
    }
    
    private boolean isPartBridgeExist(final int currentPosition) {
        return partBridge(currentPosition).equals(BridgeConstants.UPPER_COMPARTMENT);
    }
    
    private String partBridge(final int currentPosition) {
        return bridge.get(currentPosition);
    }
}
