package bridge.domain;

public class Stage {
    private static int stage = 0;

    public void nextStage() {
        stage++;
    }

    public void resetStage() {
        stage = 0;
    }
}
