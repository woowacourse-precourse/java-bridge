package bridge.repository;

import bridge.domain.Bridge;
import bridge.domain.enums.BlockStatus;
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

    public List<BlockStatus> storeBridge(final List<String> symbolBlocks) {
        clearStore();
        List<BlockStatus> blocks = BlockStatus.convertToBlockStatues(symbolBlocks);
        store.add(new Bridge(blocks));
        return blocks;
    }

    public void clearStore() {
        store.clear();
    }

}

