package bridge;

public class BridgeResults {
    private static final String UP = "U";
    private static final String SUCCESS = "O";
    private static final String FAIL = "X";

    private final BridgeResult upBridgeResult;
    private final BridgeResult downBridgeResult;

    public BridgeResults() {
        this.upBridgeResult = new BridgeResult();
        this.downBridgeResult = new BridgeResult();
    }

    public BridgeResult getUpBridgeResult() {
        return upBridgeResult;
    }

    public BridgeResult getDownBridgeResult() {
        return downBridgeResult;
    }

    public void report(BridgeLocationStatus bridgeLocationStatus, boolean compareBridgeLocationResult) {
        BridgeResult bridgeResult = getBridgeResult(bridgeLocationStatus);
        String compareBridgeResult = getCompareBridgeResult(compareBridgeLocationResult);
        bridgeResult.add(compareBridgeResult);
    }

    private BridgeResult getBridgeResult(BridgeLocationStatus bridgeLocationStatus) {
        if (bridgeLocationStatus.compareBridge(UP)) {
            downBridgeResult.none();
            return upBridgeResult;
        }
        upBridgeResult.none();
        return downBridgeResult;
    }

    private String getCompareBridgeResult(boolean compareBridgeLocationResult) {
        if(compareBridgeLocationResult) {
            return SUCCESS;
        }
        return FAIL;
    }

    public void revert() {
        upBridgeResult.revert();
        downBridgeResult.revert();
    }
}
