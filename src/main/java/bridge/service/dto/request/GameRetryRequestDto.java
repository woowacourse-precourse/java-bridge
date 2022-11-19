package bridge.service.dto.request;

public class GameRetryRequestDto {
    private final String retry;

    public GameRetryRequestDto(String retry) {
        this.retry = retry;
    }

    public String getRetry() {
        return this.retry;
    }
}
