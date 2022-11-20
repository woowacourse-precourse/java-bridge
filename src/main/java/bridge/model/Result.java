package bridge.model;

public class Result {

    private int tryCount = 0;

    public void addTryCount() {
        tryCount +=1;
    }

    public int getTryCount() {
        return tryCount;
    }
}