package bridge.model;

public class Statistics {
    private int countRetry = 1;
    private boolean isClear = false;

    public void countRetry() {
        countRetry++;
    }

    public void gameClear() {
        isClear = true;
    }

    public int getCountRetry() {
        return countRetry;
    }

    public boolean isClear() {
        return isClear;
    }
}
