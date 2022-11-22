package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> positions;

    private Bridge(List<String> positions) {
        this.positions = positions;
    }
    public static Bridge of(List<String> positions){
        return new Bridge(positions);
    }

    public int getSize() {
        return positions.size();
    }

    public boolean isEqual(int index, BridgeGamePosition position) {
        return position == BridgeGamePosition.checkBridgePosition(positions.get(index));
    }
}
