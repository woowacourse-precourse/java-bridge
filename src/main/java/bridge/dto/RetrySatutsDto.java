package bridge.dto;

//bridgeStatusDto와 다시시작여부를 이동시킨다.
public class RetrySatutsDto {
    private final BridgeStatusDto bridgeStatusDto;
    private final boolean retryFlag;

    public RetrySatutsDto(BridgeStatusDto bridgeStatusDto, boolean retryFlag) {
        this.bridgeStatusDto = bridgeStatusDto;
        this.retryFlag = retryFlag;
    }

    public BridgeStatusDto getBridgeStatusDto() {
        return bridgeStatusDto;
    }

    public boolean isRetryFlag() {
        return retryFlag;
    }
}
