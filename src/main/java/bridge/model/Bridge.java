package bridge.model;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean canMove(Player player) {
        return player.getDirections().size() < bridge.size();
    }

}
