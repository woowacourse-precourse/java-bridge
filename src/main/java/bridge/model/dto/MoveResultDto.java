package bridge.model.dto;

import java.util.List;

public class MoveResultDto {

    private final List<Integer> bridgeMap;
    private final boolean isRightLastBridgePick;
    private final boolean isMovableStatus;

    public MoveResultDto(List<Integer> bridgeMap, boolean isRightLastBridgePick, boolean isMovableStatus) {
        this.bridgeMap = bridgeMap;
        this.isRightLastBridgePick = isRightLastBridgePick;
        this.isMovableStatus = isMovableStatus;
    }

    public List<Integer> getBridgeMap() {
        return bridgeMap;
    }

    public boolean isRightLastBridgePick() {
        return isRightLastBridgePick;
    }

    public boolean isMovableStatus() {
        return isMovableStatus;
    }
}
