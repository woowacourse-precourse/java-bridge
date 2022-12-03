package bridge.domain.model;

public class GameProgress {

    private static final int FIRST_TRIAL = 1;
    private static final int ZERO = 0;
    private static final int COUNT = 1;

    private int bridgeLength;
    private int trial;
    private int totalTrial;

    public GameProgress() {
        totalTrial = ZERO;
        bridgeLength = ZERO;
    }

    public void initialize() {
        trial = ZERO;
    }

    public void updateTrial() {
        trial++;
    }

    public int noticeTrial() {
        return trial;
    }

    public boolean isFirstTrial() {
        return trial == FIRST_TRIAL;
    }

    public void updateTotalCount() {
        totalTrial += COUNT;
    }

    public int getTotalTrial() {
        return totalTrial;
    }

    public boolean isGameContinued() {
        return trial < bridgeLength;
    }

    public void updateBridgeLength(int bridgeLength) {
        this.bridgeLength = bridgeLength;
    }
}
