package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> positions;

    private Bridge(final List<String> positions) {
        this.positions = positions;
    }
    public static Bridge of(final List<String> positions){
        return new Bridge(positions);
    }

    public int getSize() {
        return positions.size();
    }

    public boolean isEqual(final int index, final BridgeGamePosition position) {
        return position == BridgeGamePosition.checkBridgePosition(positions.get(index));
    }
}
