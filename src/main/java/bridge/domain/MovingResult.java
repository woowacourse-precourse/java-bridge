package bridge.domain;

public class MovingResult {
    BridgeBlock bridgeBlock;
    private String State;

    public MovingResult(BridgeBlock bridgeBlock, String state) {
        this.bridgeBlock = bridgeBlock;
        this.State = state;
    }

    public boolean isCorrect() {
        return this.State.equals("O");
    }

    public BridgeBlock getBridgeBlock() {
        return bridgeBlock;
    }

    public String getState() {
        return State;
    }
}
