package bridge.domain.player;

import bridge.domain.game.Bridge;
import bridge.domain.game.BridgeTile;
import bridge.utils.common.BridgeConst;
import bridge.utils.message.ExceptionMessageUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Player {

    private static final String HISTORY_SEPARATOR = " | ";

    private final List<BridgeTile> playerStepHistory;
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

    public boolean move(final Bridge bridge, final BridgeTile playerStep) {
        int playerPosition = playerStepHistory.size();

        playerStepHistory.add(playerStep);
        return bridge.calculatePlayerMoving(playerStep, playerPosition);
    }

    public String getPlayerTargetTileHistory(final Bridge bridge, final BridgeTile targetTile) {
        return IntStream.range(0, playerStepHistory.size())
            .mapToObj(position -> playerStepHistory.get(position)
                    .getBridgeTileLog(bridge, targetTile, position))
            .collect(Collectors.joining(HISTORY_SEPARATOR));
    }

    public boolean isSuccessful(final Bridge bridge) {
        if (playerStepHistory.size() < BridgeConst.MIN_BRIDGE_SIZE) {
            return false;
        }
        return lastPlayerStepMovable(bridge);
    }

    private boolean lastPlayerStepMovable(final Bridge bridge) {
        int playerSteps = playerStepHistory.size() - 1;

        return bridge.calculatePassingBridge(playerSteps, playerStepHistory.get(playerSteps));
    }

    public void preparedNextPlay() {
        playerStepHistory.clear();
        tryCount++;
    }

    public long getTryCount() {
        return tryCount;
    }
}
