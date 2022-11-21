package bridge.model;

import java.util.List;

public class Bridges {
    private final List<String> bridges;

    Bridges(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridges = bridgeMaker.makeBridge(size);
    }

    boolean isCompletedGame(Player player) {
        return player.isCompletedGame(bridges.size());
    }

    boolean isSuccess(Player player) {
        return player.isSuccess(getBridges());
    }

    private List<String> getBridges() {
        return List.copyOf(bridges);
    }
}
