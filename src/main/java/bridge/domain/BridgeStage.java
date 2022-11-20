package bridge.domain;

public class BridgeStage {
    private int stage = 0;

    public void nextStage() {
        stage++;
    }

    public int currentStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public boolean isFinalStage(int bridgeSize, int stage) {
        if ((bridgeSize - 1) == stage) {
            return true;
        }

        return false;
    }
}
