package bridge.domain;

import bridge.model.Player;

public class BridgeMove {
    public void movePlayer(Player player, String moveTo) {
        player.setPosition(moveTo);
    }
}
