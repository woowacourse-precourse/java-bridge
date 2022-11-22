package bridge.service;

import bridge.domain.Bridge;

public class BridgeService {
    private static BridgeService instance = new BridgeService();

    public static BridgeService getInstance() {
        return instance;
    }

    private BridgeService() {}

    public Bridge create (int bridgeLength) {
        return new Bridge(bridgeLength);
    }
}
