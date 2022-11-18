package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.Movement;
import bridge.domain.Player;
import bridge.domain.GameStatus;
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

    public GameStatus movePlayer(Movement playerMove) {
        boolean playerCrossable = bridge.isCrossable(playerMove, player.getPlayerPosition());
        player.crossOverBridge(playerMove, playerCrossable);
        boolean isReachedBridge = bridge.isReachedTheEnd(player.getPlayerPosition());
        return GameStatus.findByStatus(playerCrossable, isReachedBridge);
    }

}
