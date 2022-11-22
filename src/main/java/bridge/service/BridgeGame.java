package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.Movement;
import bridge.domain.Player;
import bridge.domain.Result;

public class BridgeGame {

    private final Bridge bridge;
    private final Player player;

    public BridgeGame(Bridge bridge, Player player) {
        this.bridge = bridge;
        this.player = player;
    }

    public boolean move(Movement directionInput) {
        player.updateMovement(directionInput);
        if (!player.matchPlayerAndBridge(bridge)) {
            return false;
        }
        return true;
    }

    public void retry(Result result) {
        result.updateNumberOfTrials();
        player.resetPlayer();
        result.resetGameResult();
    }
}
