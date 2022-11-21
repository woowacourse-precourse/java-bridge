package bridge.dto;

import bridge.model.Bridge;
import bridge.model.BridgeResult;
import bridge.model.Retry;

public class ResultDto {

    private MapDto mapDto;

    private boolean success;

    private int tryCount;


    public ResultDto(Bridge bridge, BridgeResult bridgeResult, Retry retry) {
        this.mapDto = new MapDto(bridge, bridgeResult);
        this.success = bridgeResult.checkSuccess(bridge);
        this.tryCount = retry.getCount();
    }

    public MapDto getMapDto() {
        return mapDto;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getTryCount() {
        return tryCount;
    }
}
