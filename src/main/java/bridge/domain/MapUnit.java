package bridge.domain;

public class MapUnit {
    private final BridgeUnit bridgeUnit;
    private final boolean success;

    public MapUnit(BridgeUnit bridgeUnit, boolean success) {
        this.bridgeUnit = bridgeUnit;
        this.success = success;
    }

    public BridgeUnit getBridgeUnit() {
        return bridgeUnit;
    }

    public boolean isSuccess() {
        return success;
    }
}
