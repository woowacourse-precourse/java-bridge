package bridge.domain;

public enum BridgePhase {
    DOWN(0), UP(1);

    private final int phase;

    BridgePhase(int phaseNum) {
        this.phase = phaseNum;
    }
}
