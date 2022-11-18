package bridge.vo;

public class StepResult {
    private final BridgeStep bridgeStep;
    private final boolean isCorrect;

    public StepResult(BridgeStep bridgeStep, boolean isCorrect) {
        this.bridgeStep = bridgeStep;
        this.isCorrect = isCorrect;
    }

    public BridgeStep getBridgeStep() {
        return bridgeStep;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
