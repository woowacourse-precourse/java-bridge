package bridge.domain.game;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.domain.player.PlayerState;
import bridge.utils.common.BridgeConst;
import bridge.utils.message.ExceptionMessageUtils;
import java.util.Collections;
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

    public boolean calculatePlayerMoving(final BridgeTile playerStep, final PlayerState playerState) {
        return playerState.findPlayerPositionTile(Collections.unmodifiableList(bridgeTiles)) == playerStep;
    }

    public boolean isEndOfBridge(int playerPosition) {
        return bridgeTiles.size() == playerPosition;
    }
}
