package bridge.model;

import java.util.List;

public class Bridges {
    public static final int INDEX_SIZE_DIFFERENT = 1;
    private final List<String> bridges;

    Bridges(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridges = bridgeMaker.makeBridge(size);
    }

    boolean isRight(int position, String direction) {
        return bridges.get(position - INDEX_SIZE_DIFFERENT).equals(direction);
    }

    boolean isCompletedGame(Player player) {
        return player.isCompletedGame(bridges.size());
    }
}
