package bridge.controller.request;

public class MakeBridgeRequest {

    private final int bridgeSize;

    public MakeBridgeRequest(int bridgeSize) {
        this.bridgeSize = bridgeSize;
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
