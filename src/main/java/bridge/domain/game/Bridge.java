package bridge.domain.game;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.utils.common.BridgeConst;
import bridge.utils.message.ExceptionMessageUtils;
import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

    private final List<BridgeTile> bridge;

    public Bridge(int size) {
        validateBridgeSize(size);

        List<String> bridge = makeBridgeCommand(size);

        this.bridge = bridge
                .stream()
                .map(BridgeTile::findTile)
                .collect(Collectors.toList());
    }

    private void validateBridgeSize(int size) {
        if (!(BridgeConst.MIN_BRIDGE_SIZE <= size && size <= BridgeConst.MAX_BRIDGE_SIZE)) {
            throw new IllegalArgumentException(ExceptionMessageUtils.WRONG_BRIDGE_SIZE.getMessage());
        }
    }

    private List<String> makeBridgeCommand(int size) {
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);

        return bridgeMaker.makeBridge(size);
    }
}
