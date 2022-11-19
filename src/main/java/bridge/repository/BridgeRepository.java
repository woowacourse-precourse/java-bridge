package bridge.repository;

import bridge.domain.bridge.Bridge;

public class BridgeRepository {
    private final static BridgeRepository bridgeRepository = new BridgeRepository();
    private Bridge bridge;

    private BridgeRepository() {
    }

    public static BridgeRepository getInstance() {
        return bridgeRepository;
    }

    public void update(Bridge bridge) {
        this.bridge = bridge;
    }

    public String getPassableDirectionAt(int distance) {
        return bridge.passableDirectionAt(distance);
    }
}
