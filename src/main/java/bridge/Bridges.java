package bridge;

import java.util.List;

public class Bridges {
    public static final int INDEX_SIZE_DIFFERENT = 1;
    private final int size;
    private final List<String> bridges;

    public Bridges(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        this.size = size;
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridges = bridgeMaker.makeBridge(size);
    }

    public boolean isSameDirection(int position, String direction) {
        return bridges.get(position - INDEX_SIZE_DIFFERENT).equals(direction);
    }

    public boolean isEnd(Player player) {
        return player.isCompleted(size);
    }


}
