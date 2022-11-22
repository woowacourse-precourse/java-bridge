package bridge.domain.history;

import bridge.domain.bridge.BridgeMove;

public class BridgeMoveResult {
    
    private final BridgeMove bridgeMove;
    private final BridgeMoveResultStatus status;
    
    public BridgeMoveResult(BridgeMove bridgeMove, BridgeMoveResultStatus status) {
        this.bridgeMove = bridgeMove;
        this.status = status;
    }
    
    public BridgeMove getBridgeMove() {
        return bridgeMove;
    }
    
    public BridgeMoveResultStatus getStatus() {
        return status;
    }
}
