package bridge.dto;

import bridge.model.entity.RetryCount;

public class RetryCountDto {
    private final long retryCount;

    private RetryCountDto(RetryCount retryCount) {
        this.retryCount = retryCount.getRetryCount();
    }

    public long getRetryCount() {
        return this.retryCount;
    }

    public static RetryCountDto of(RetryCount retryCount) {
        return new RetryCountDto(retryCount);
    }

}
