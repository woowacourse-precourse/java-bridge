package bridge.model;

import java.util.List;

public class Bridges {
    public static final int INDEX_SIZE_DIFFERENT = 1;
    private final List<String> bridges;

    Bridges(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridges = new BridgeMaker(bridgeNumberGenerator).makeBridge(size);
    }

    boolean isRight(int position, String direction) {
        return getDirection(position).equals(direction);
    }

    private String getDirection(int position) {
        return bridges.get(getIndex(position));
    }

    private static int getIndex(int position) {
        return position - INDEX_SIZE_DIFFERENT;
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
