package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.GameRecord;
import bridge.domain.Player;
import java.util.List;
import java.util.Map;

public class BridgeGame {
    private final Bridge bridge;
    private final Player player;
    private GameRecord gameRecord;

    public BridgeGame(Bridge bridge, Player player) {
        this.bridge = bridge;
        this.player = player;
        this.gameRecord = new GameRecord();
    }

    public boolean isFinished() {
        return (player.isArrived(bridge) || player.isDead());
    }

    public boolean isFailed() {
        return player.isDead();
    }

    public void move(String spaceToMove) {
        player.move(bridge, spaceToMove);
        gameRecord.recordMove(spaceToMove, player.isDead());
    }

    public void retry() {
        player.reVive();
        gameRecord.recordRetry();
    }

    public int getTryCount() {
        return gameRecord.getTryCount();
    }

    public Map<String, List<String>> getCrossedRecord() {
        return gameRecord.getCrossedRecord();
    }
}
