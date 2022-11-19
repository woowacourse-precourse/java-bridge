package bridge.domain;

public class MovingResult {
    BridgeBlock bridgeBlock;
    private String State;

    public MovingResult(BridgeBlock bridgeBlock, String state) {
        this.bridgeBlock = bridgeBlock;
        this.State = state;
    }
}
