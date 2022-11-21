package bridge.domain.history;


import bridge.domain.code.BridgePosition;
import bridge.domain.code.SurviveStatus;

public class StagedHistory {
    private final SurviveStatus surviveStatus;
    private final BridgePosition bridgePosition;

    public StagedHistory(SurviveStatus surviveStatus, BridgePosition bridgePosition) {
        this.surviveStatus = surviveStatus;
        this.bridgePosition = bridgePosition;
    }

    public String resultSurviveStatusByBridgePosition(BridgePosition position) {
        return surviveStatus.resultSurviveStatus(this.bridgePosition.equals(position));
    }
}
