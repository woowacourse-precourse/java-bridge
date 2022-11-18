package bridge.domain.player;

import bridge.domain.game.Bridge;
import bridge.domain.game.BridgeTile;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    private static final String HISTORY_SEPARATOR = " | ";

    private final List<PlayerStep> playerStepHistory;
    private int position;

    public Player() {
        this.playerStepHistory = new ArrayList<>();
        this.position = 0;
    }

    public void clearPlayerInfo() {
        this.playerStepHistory.clear();
        position = 0;
    }

    public boolean move(Bridge bridge, BridgeTile playerStep) {
        boolean moving = bridge.calculatePlayerMoving(playerStep, position++);
        playerStepHistory.add(new PlayerStep(playerStep, moving));

        return moving;
    }

    public String getPlayerTargetTileHistory(BridgeTile targetTile) {
        return playerStepHistory
                .stream()
                .map(playerAnswer -> changeLogFromHistory(playerAnswer, targetTile))
                .collect(Collectors.joining(HISTORY_SEPARATOR));
    }

    private String changeLogFromHistory(PlayerStep playerStep, BridgeTile targetTile) {
        return playerStep.getMoveResultLog(targetTile);
    }

    public boolean success(Bridge bridge) {
        if (position == 0) {
            return false;
        }
        return bridge.isEnd(position) && playerStepHistory.get(position - 1).isMoving();
    }
}
