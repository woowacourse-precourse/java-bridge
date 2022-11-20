package bridge.domain;

public class BridgeStage {
    private int stage = 0;

    public void nextStage() {
        stage++;
    }

    public int currentStage() {
        return stage;
    }
}
