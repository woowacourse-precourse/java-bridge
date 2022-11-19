package bridge.dto;

public class ResultDto {

    private int tryCount;

    private boolean isComplete;

    private BridgeRouteDto bridgeRouteDto;

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

    public BridgeRouteDto getCurrentPositionDto() {
        return bridgeRouteDto;
    }
}
