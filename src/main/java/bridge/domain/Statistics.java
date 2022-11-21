package bridge.domain;

public class Statistics {

    private int tryCount;

    public Statistics() {
        this.tryCount = 0;
    }

    public void update() {
        this.tryCount += 1;
    }

    public int getTryCount() {
        return tryCount;
    }
}
