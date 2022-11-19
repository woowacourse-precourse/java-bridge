package bridge.dto;

import bridge.model.Bridge;
import bridge.model.BridgeResult;
import java.util.List;

public class MapDto {

    private List<String> bridge;

    private List<Boolean> result;

    public List<String> getBridge() {
        return bridge;
    }

    public List<Boolean> getResult() {
        return result;
    }

    public MapDto(Bridge bridge, BridgeResult bridgeResult) {
        this.bridge = bridge.getBridge();
        this.result = bridgeResult.getResult();
    }
}
