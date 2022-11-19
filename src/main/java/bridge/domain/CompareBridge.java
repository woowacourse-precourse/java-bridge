package bridge.domain;

import java.util.List;

public class CompareBridge {
    private Player player;
    private List<String> bridge;

    public CompareBridge(Player player, List<String> bridge) {
        this.player = player;
        this.bridge = bridge;
    }

    public boolean isSame(Player player, String panel) {
        return player.informMoving().equals(panel);
    }

    public String stepping(Player player, List<String> bridge) {
        if (isSame(player, bridge.get(0))) {
            return " O ";
        }
        return " X ";
    }
}