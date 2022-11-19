package bridge.repository;

import bridge.domain.Bridge;
import java.util.ArrayList;
import java.util.List;

public class BridgeGameRepository {
    private static final BridgeGameRepository instance = new BridgeGameRepository();
    private static final List<Bridge> store = new ArrayList<>();

    private BridgeGameRepository() {
    }

    public static BridgeGameRepository getInstance() {
        return instance;
    }

    public List<String> storeBridge(final List<String> symbolBlocks) {
        clearStore();
        store.add(new Bridge(symbolBlocks));
        return symbolBlocks;
    }

    public void clearStore() {
        store.clear();
    }

}

