package bridge.model;

public class BridgeStatusModel {

    private final String currentBridge;

    public BridgeStatusModel(String currentBridge) {
        this.currentBridge = currentBridge;
    }

    public String getCurrentBridge() {
        return currentBridge;
    }
}
