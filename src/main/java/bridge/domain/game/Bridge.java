package bridge.domain.game;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.utils.common.BridgeConst;
import bridge.utils.message.ExceptionMessageUtils;
import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

    private final List<BridgeTile> bridgeTiles;

    public Bridge(int size, final BridgeNumberGenerator generator) {
        validateBridgeSize(size);

        List<String> bridgeCommand = makeBridgeCommand(size, generator);

        this.bridgeTiles = bridgeCommand
                .stream()
                .map(BridgeTile::findTile)
                .collect(Collectors.toList());
    }

    private void validateBridgeSize(int size) {
        if (!isValidRangeSize(size)) {
            throw new IllegalArgumentException(ExceptionMessageUtils.WRONG_BRIDGE_SIZE.getMessage());
        }
    }

    private boolean isValidRangeSize(int size) {
        return BridgeConst.MIN_BRIDGE_SIZE <= size && size <= BridgeConst.MAX_BRIDGE_SIZE;
    }

    private List<String> makeBridgeCommand(int size, final BridgeNumberGenerator generator) {
        BridgeMaker bridgeMaker = new BridgeMaker(generator);

        return bridgeMaker.makeBridge(size);
    }

    public boolean calculatePlayerMoving(final BridgeTile playerStep, int playerPosition) {
        return bridgeTiles.get(playerPosition) == playerStep;
    }

    public boolean calculatePassingBridge(int playerPosition, final BridgeTile playerStep) {
        int lastBridgeTileIndex = bridgeTiles.size() - 1;

        return isEndOfBridge(lastBridgeTileIndex, playerPosition)
                && isMovable(lastBridgeTileIndex, playerStep);
    }

    private boolean isMovable(int lastBridgeTileIndex, final BridgeTile playerStep) {
        return bridgeTiles.get(lastBridgeTileIndex) == playerStep;
    }

    private boolean isEndOfBridge(int lastBridgeTileIndex, int playerPosition) {
        return lastBridgeTileIndex == playerPosition;
    }
}
