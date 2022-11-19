package bridge.domain;

import bridge.BridgeMove;

public class BridgeMoveHistory {
    private final BridgeMove bridgeMove;
    private final boolean isSuccess;
    
    
    public BridgeMoveHistory(BridgeMove bridgeMove, boolean isSuccess) {
        this.bridgeMove = bridgeMove;
        this.isSuccess = isSuccess;
    }
    
    public BridgeMove getBridgeMove() {
        return bridgeMove;
    }
    
    public boolean isSuccess() {
        return isSuccess;
    }
}
