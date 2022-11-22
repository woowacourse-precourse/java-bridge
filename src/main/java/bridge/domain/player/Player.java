package bridge.domain.player;

import bridge.domain.game.Bridge;
import bridge.domain.game.BridgeTile;
import bridge.utils.common.BridgeConst;
import bridge.utils.message.ExceptionMessageUtils;

public class Player {

    private final PlayerStepHistory playerStepHistory;
    private final PlayerState playerState;

    public Player(int size) {
        validateBridgeSize(size);

        playerStepHistory = new PlayerStepHistory();
        playerState = new PlayerState();
    }

    private void validateBridgeSize(int size) {
        if (!isValidRangeSize(size)) {
            throw new IllegalArgumentException(ExceptionMessageUtils.WRONG_BRIDGE_SIZE.getMessage());
        }
    }

    private boolean isValidRangeSize(int size) {
        return BridgeConst.MIN_BRIDGE_SIZE <= size && size <= BridgeConst.MAX_BRIDGE_SIZE;
    }

    public boolean move(final Bridge bridge, final BridgeTile playerStep) {
        boolean movable = bridge.calculatePlayerMoving(playerStep, playerState);

        playerState.move(movable);
        playerStepHistory.updateHistory(playerStep, movable);
        return movable;
    }

    public String getPlayerTargetTileHistory(final BridgeTile targetTile) {
        return playerStepHistory.getPlayerTargetTileHistory(targetTile);
    }

    public boolean isSuccessful(final Bridge bridge) {
        return playerState.isSuccessful(bridge);
    }

    public void preparedNextPlay() {
        playerState.preparedNextPlay();
        playerStepHistory.clear();
    }

    public long getTryCount() {
        return playerState.getTryCount();
    }
}
