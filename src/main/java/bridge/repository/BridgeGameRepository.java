package bridge.repository;

import bridge.domain.Bridge;
import java.util.ArrayList;
import java.util.List;

public class BridgeGameRepository {
    private static final BridgeGameRepository instance = new BridgeGameRepository();
    private static final List<Bridge> store = new ArrayList<>();
    public static final int BRIDGE_GET = 0;

    private BridgeGameRepository() {
    }

    public static BridgeGameRepository getInstance() {
        return instance;
    }

    public Bridge storeBridge(final Bridge bridge) {
        clearStore();
        store.add(bridge);
        return findBridge();
    }

    private Bridge findBridge() {
        return store.get(BRIDGE_GET);
    }

    public void clearStore() {
        store.clear();
    }

}

