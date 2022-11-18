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
    private int numberOfAttempts;

    public BridgeService(Bridge bridge) {
        this.bridge = bridge;
        numberOfAttempts = 0;
        init();
    }

    public void init() {
        this.player = new Player();
        this.numberOfAttempts += 1;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public Map<Movement, List<String>> getResultCrossOver() {
        return player.getMovementStatus();
    }

    public GameStatus movePlayer(Movement playerMove) {
        boolean playerCrossable = bridge.isCrossable(playerMove, player.getPlayerPosition());
        player.crossOverBridge(playerMove, playerCrossable);
        boolean isReachedBridge = bridge.isReachedTheEnd(player.getPlayerPosition());
//        numberOfAttempts += 1;
        return GameStatus.findByStatus(playerCrossable, isReachedBridge);
    }

}
