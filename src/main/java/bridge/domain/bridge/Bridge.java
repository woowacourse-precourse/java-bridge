package bridge.domain.bridge;

import bridge.domain.player.Player;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    private Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public static Bridge of(int size, BridgeMaker bridgeMaker) {
        return new Bridge(bridgeMaker.makeBridge(size));
    }

    public boolean isMovable(Player player) {
        int top = player.getTopIndex();
        return bridge.get(top).equals(player.getTop());
    }

    public int getBridgeSize() {
        return bridge.size();
    }
}
