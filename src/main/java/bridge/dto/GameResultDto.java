package bridge.dto;

public class GameResultDto {

    private final BridgeResultDto bridgeResultDto;
    private final String success;
    private final int retryCount;

    public GameResultDto(BridgeResultDto bridgeResultDto,
                         String success,
                         int retryCount) {
        this.bridgeResultDto = bridgeResultDto;
        this.success = success;
        this.retryCount = retryCount;
    }

    public BridgeResultDto getBridgeResultDto() {
        return bridgeResultDto;
    }

    public String getSuccess() {
        return success;
    }

    public int getRetryCount() {
        return retryCount;
    }
}
