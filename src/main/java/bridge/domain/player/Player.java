package bridge.domain.player;

import bridge.domain.game.Bridge;
import bridge.domain.game.BridgeTile;
import bridge.utils.common.BridgeConst;
import bridge.utils.message.ExceptionMessageUtils;

public class Player {

    private final MovingPathHistory movingPathHistory;
    private final PlayerState playerState;

    public Player(int size) {
        validateBridgeSize(size);

        movingPathHistory = new MovingPathHistory();
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
        movingPathHistory.updateHistory(playerStep, movable);
        return movable;
    }

    public String getPlayerTargetTileHistory(final BridgeTile targetTile) {
        return movingPathHistory.getPlayerTargetTileHistory(targetTile);
    }

    public boolean isSuccessful(final Bridge bridge) {
        return playerState.isSuccessful(bridge);
    }

    public void preparedNextPlay() {
        playerState.preparedNextPlay();
        movingPathHistory.clear();
    }

    public long getTryCount() {
        return playerState.getTryCount();
    }
}
