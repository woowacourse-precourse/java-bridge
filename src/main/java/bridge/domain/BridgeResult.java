package bridge.domain;

public class BridgeResult {

    private final String nowStep;
    private final boolean nowResult;

    public BridgeResult(String nowStep, boolean nowResult) {
        this.nowStep = nowStep;
        this.nowResult = nowResult;
    }
}
