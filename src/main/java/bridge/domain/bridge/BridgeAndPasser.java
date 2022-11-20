package bridge.domain.bridge;

public class BridgeAndPasser {

    private final Bridge bridge;
    private BridgePasser bridgePasser;

    public BridgeAndPasser(Bridge bridge, BridgePasser bridgePasser) {
        this.bridge = bridge;
        this.bridgePasser = bridgePasser;
    }

    public static BridgeAndPasser compress(Bridge bridge, BridgePasser bridgePasser) {
        return new BridgeAndPasser(bridge, bridgePasser);
    }

    public BridgePasser getBridgePasser() {
        return bridgePasser;
    }

    public Bridge getBridge() {
        return bridge;
    }
}
