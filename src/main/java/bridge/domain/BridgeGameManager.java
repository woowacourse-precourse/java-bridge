package bridge.domain;

public class BridgeGameManager {
    private int count;
    private int step;

    public BridgeGameManager() {
        count = 1;
        step = 0;
    }
    
    public int getStep() {
        return step;
    }

    public int getCount() {
        return count;
    }


    public void increaseCount() {
        count++;
    }

    public void increaseStep() {
        step++;
    }

    public void gameFail() {
        step = -1;
    }
}
