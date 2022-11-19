package bridge.model;

public class FinalResult {
    private int attempts = 1;
    private boolean finalSuccess = false;

    public void addAttempts() {
        attempts++;
    }

    public void setFinalSuccess() {
        finalSuccess = true;
    }

    public boolean isFinalSuccess() {
        return finalSuccess;
    }

    public int getAttempts() {
        return attempts;
    }

}
