package bridge.domain;

public enum BridgeStep {
    UP("U"),DOWN("D");

    private final String step;

    BridgeStep(String step) {
        this.step = step;
    }

    public String getStep() {
        return this.step;
    }

}
