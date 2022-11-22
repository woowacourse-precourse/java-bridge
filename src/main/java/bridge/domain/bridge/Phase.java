package bridge.domain.bridge;

public class Phase {

    private int currentPhase;

    public Phase() {
        this.currentPhase = 0;
    }

    public int getCurrentPhase() {
        return currentPhase;
    }

    public void nextPhase() {
        this.currentPhase++;
    }

    public void resetPhase() {
        this.currentPhase = 0;
    }
}
