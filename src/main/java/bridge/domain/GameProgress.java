package bridge.domain;

public class GameProgress {

    private boolean success;
    private int trialCount;

    public GameProgress() {
        this.success = false;
        this.trialCount = 1;
    }

    public int getTrialCount() {
        return trialCount;
    }

    public boolean isGameSuccess() {
        return success;
    }

    public void updateTrialCount() {
        trialCount++;
    }

    public void victoryGame() {
        success = true;
    }
}
