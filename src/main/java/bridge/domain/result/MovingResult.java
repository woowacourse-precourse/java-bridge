package bridge.domain.result;

import bridge.domain.bridge.BridgeBlock;

public class MovingResult {
    BridgeBlock bridgeBlock;
    private String State;

    public MovingResult(BridgeBlock bridgeBlock, String state) {
        this.bridgeBlock = bridgeBlock;
        this.State = state;
    }

    public BridgeBlock getBridgeBlock() {
        return bridgeBlock;
    }

    public String getState() {
        return State;
    }
}
