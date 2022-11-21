package bridge.model.entity;

public class RetryCount {
    private long retryCount = 1L;

    public long getRetryCount() {
        return this.retryCount;
    }

    public void upCount() {
        this.retryCount += 1L;
    }

    public static RetryCount of() {
        return new RetryCount();
    }

}
