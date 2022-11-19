package bridge.domain;

import java.util.List;

final class Bridge {
    private final List<String> positions;

    public Bridge(List<String> positions) {
        this.positions = positions;
    }

    public int size() {
        return positions.size();
    }

    public boolean isEqualAtIndex(int index, Position position) {
        return position == Position.from(positions.get(index));
    }
}
