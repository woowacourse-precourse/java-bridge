package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.Movement;
import bridge.domain.Player;
import java.util.List;
import java.util.Map;

public class BridgeService {
    private final Bridge bridge;
    private Player player;

    public BridgeService(Bridge bridge) {
        this.bridge = bridge;
        init();
    }

    public void init() {
        player = new Player();
    }

    public Map<Movement, List<String>> getResultCrossOver() {
        return player.getMovementStatus();
    }

    public boolean movePlayer(Movement playerMove) {
        boolean playerMoveable = bridge.isMoveable(playerMove, player.getPlayerPosition());
        player.crossOverBridge(playerMove, playerMoveable);
        return playerMoveable;
    }

}
