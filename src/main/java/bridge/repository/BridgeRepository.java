package bridge.repository;

import bridge.domain.bridge.Bridge;

public class BridgeRepository {
    private static final BridgeRepository bridgeRepository = new BridgeRepository();

    private Bridge bridge;

    private BridgeRepository() {
    }

    public static BridgeRepository getInstance() {
        return bridgeRepository;
    }

    public void update(Bridge bridge) {
        this.bridge = bridge;
    }
}
