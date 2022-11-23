package bridge.cache;

import bridge.domain.BridgeStatus;

public class BridgeStatusSaver {

    private static final String ERROR_NOT_INITIALIZE = "BridgeStatus를 초기화해야 객체를 가져올 수 있습니다.";
    private BridgeStatus bridgeStatus;


    public BridgeStatus getBridgeStatus() {
        validateExistState();
        return bridgeStatus;
    }

    public void setBridgeStatus(BridgeStatus bridgeStatus) {
        this.bridgeStatus = bridgeStatus;
    }

    private void validateExistState() {
        if (bridgeStatus == null) {
            throw new IllegalStateException(ERROR_NOT_INITIALIZE);
        }
    }
}
