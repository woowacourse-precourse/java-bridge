package bridge.Model;

public class BridgeGame {

    public void move(BridgeDTO bridgeDTO) {
        bridgeDTO.setMovePoint(bridgeDTO.getMovePoint() + 1);
    }

    public void retry(BridgeDTO bridgeDTO) {
        bridgeDTO.setMovePoint(0);
        bridgeDTO.clearInitializeLine();
        bridgeDTO.setRetry(bridgeDTO.getRetry() + 1);
    }
}
