package bridge.domain;

import bridge.BridgeMaker;
import bridge.command.BridgeSizeCommand;

import java.util.List;

final class Bridge {
    private final List<String> positions;

    private Bridge(final List<String> positions) {
        this.positions = positions;
    }

    static Bridge from(final BridgeMaker bridgeMaker, final BridgeSizeCommand sizeCommand) {
        final List<String> bridge = bridgeMaker.makeBridge(sizeCommand.getBridgeSize());
        return new Bridge(bridge);
    }

    public int size() {
        return positions.size();
    }

    boolean isEqualAtIndex(final int index, final Position position) {
        return position == Position.from(positions.get(index));
    }
}
