package bridge.domain;

public class User {

    private Integer step = 0;
    private Integer tryCount = 1;

    public Integer getStep() {
        return step;
    }

    public Integer getTryCount() {
        return tryCount;
    }

    public void stepForward() {
        step++;
    }

    public void stepInit() {
        step = 0;
    }

    public void increaseRetryCount() {
        tryCount++;
    }
}
