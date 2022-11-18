package bridge.repository;

import bridge.domain.Bridge;

public class BridgeRepository {
    private static final BridgeRepository bridgeRepository = new BridgeRepository();

    private BridgeRepository() {
    }

    private Bridge bridge;

    public static BridgeRepository getInstance() {
        return bridgeRepository;
    }

    public void update(Bridge bridge) {
        this.bridge = bridge;
    }
}
