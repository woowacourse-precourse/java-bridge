package bridge.domain.state;

import bridge.domain.MoveResult;
import bridge.domain.constants.BridgeConstants;

import java.util.List;

public class Ready extends Started {
    public Ready(final List<String> bridge) {
        super(bridge);
    }
    
    @Override
    public MoveResult state() {
        return MoveResult.READY;
    }
    
    @Override
    public State move(final int currentPosition) {
        if (isPartBridgeExist(currentPosition)) {
            return new Success(bridge());
        }
        
        return new Fail(bridge());
    }
    
    private boolean isPartBridgeExist(final int currentPosition) {
        return partBridge(currentPosition).equals(BridgeConstants.UPPER_COMPARTMENT);
    }
    
    private String partBridge(final int currentPosition) {
        return bridge().get(currentPosition);
    }
    
    @Override
    public boolean isMoveFail() {
        throw new IllegalStateException("[ERROR] 준비 상태에선 이동 결과를 판별할 수 없습니다.");
    }
}
