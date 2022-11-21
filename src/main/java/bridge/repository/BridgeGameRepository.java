package bridge.repository;

import bridge.domain.Bridge;
import java.util.HashMap;
import java.util.Map;

public class BridgeGameRepository {
    public static final int INITIALIZE_COUNT = 1;
    public static final String BRIDGE = "bridge";
    public static final String GAME_COUNT = "gameCount";

    private static final BridgeGameRepository instance = new BridgeGameRepository();
    private static final Map<String, Object> store = new HashMap<>();

    private BridgeGameRepository() {
    }

    public static BridgeGameRepository getInstance() {
        return instance;
    }

    public Bridge storeBridge(final Bridge bridge) {
        clearStore();
        store.put(BRIDGE, bridge);
        increaseGameCount();
        return findBridge();
    }

    public Bridge findBridge() {
        return (Bridge) store.get(BRIDGE);
    }

    public int findGameCount() {
        return (int) store.get(GAME_COUNT);
    }

    public void increaseGameCount() {
        store.put(GAME_COUNT, (int) store.getOrDefault(GAME_COUNT, INITIALIZE_COUNT) + 1);
    }

    public void clearStore() {
        store.clear();
    }

}

