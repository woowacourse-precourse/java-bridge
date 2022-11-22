package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> positions;

    public Bridge(List<String> positions) {
        this.positions = positions;
    }

    public int getSize() {
        return positions.size();
    }

    public boolean isEqual(int index, BridgeGamePosition position) {
        return position == BridgeGamePosition.checkBridgePosition(positions.get(index));
    }
}
