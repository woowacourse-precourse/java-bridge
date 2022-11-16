package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isMatched(Player player, String movement) {
        return bridge.get(player.position()).equals(movement);
    }
}
