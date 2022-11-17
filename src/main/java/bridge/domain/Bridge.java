package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isMatched(Player player, String moveCommand) {
        return bridge.get(player.position()).equals(moveCommand);
    }
}
