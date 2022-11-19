package bridge.domain;

public class User {

    private Integer step = 0;
    private Integer retryCount = 0;

    public Integer getStep() {
        return step;
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    public void stepForward() {
        step++;
    }

    public void stepInit() {
        step = 0;
    }

    public void increaseRetryCount() {
        retryCount++;
    }
}
