package bridge.domain.player;

import bridge.domain.game.Bridge;
import bridge.domain.game.BridgeTile;
import bridge.utils.common.BridgeConst;
import bridge.utils.message.ExceptionMessageUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    private static final String HISTORY_SEPARATOR = " | ";

    private final List<PlayerStep> playerStepHistory;
    private long tryCount;

    public Player(int size) {
        validateBridgeSize(size);

        this.playerStepHistory = new ArrayList<>(size);
        tryCount = 1L;
    }

    private void validateBridgeSize(int size) {
        if (!isValidRangeSize(size)) {
            throw new IllegalArgumentException(ExceptionMessageUtils.WRONG_BRIDGE_SIZE.getMessage());
        }
    }

    private boolean isValidRangeSize(int size) {
        return BridgeConst.MIN_BRIDGE_SIZE <= size && size <= BridgeConst.MAX_BRIDGE_SIZE;
    }

    public boolean move(Bridge bridge, BridgeTile playerStep) {
        boolean moving = bridge.calculatePlayerMoving(playerStep, playerStepHistory.size());
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

    public boolean isSuccessful(Bridge bridge) {
        if (playerStepHistory.size() < BridgeConst.MIN_BRIDGE_SIZE) {
            return false;
        }
        return lastPlayerStepMovable(bridge);
    }

    private boolean lastPlayerStepMovable(Bridge bridge) {
        return bridge.isEnd(playerStepHistory.size())
                && playerStepHistory.get(playerStepHistory.size() - 1).isMoving();
    }

    public void preparedNextPlay() {
        playerStepHistory.clear();
        tryCount++;
    }

    public long getTryCount() {
        return tryCount;
    }
}
