package bridge.dto;

public class ResultDto {

    private final int tryCount;

    private final boolean isComplete;

    private final BridgeRouteDto bridgeRouteDto;

    public ResultDto(int tryCount, boolean isComplete, BridgeRouteDto bridgeRouteDto) {
        this.tryCount = tryCount;
        this.isComplete = isComplete;
        this.bridgeRouteDto = bridgeRouteDto;
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean getIsComplete() {
        return isComplete;
    }

    public BridgeRouteDto getBridgeRouteDto() {
        return bridgeRouteDto;
    }
}
