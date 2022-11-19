package bridge.domain;

public class User {
    private Integer retry = 1;

    public Integer getRetry() {
        return retry;
    }

    public void retry() {
        retry++;
    }
}
