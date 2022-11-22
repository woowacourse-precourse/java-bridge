package bridge;

public class Round {
    private int tryCount = 1;
    private boolean isFinished;
    private boolean result;

    public void addTryCount() {
        this.tryCount += 1;
    }

    public boolean recordResult(boolean result) {
        if (isFinished == true) {
            return false;
        }
        isFinished = true;
        this.result = result;
        return true;
    }

    public boolean getResult() {
        return result;
    }

    public int getTryCount() {
        return tryCount;
    }
}
