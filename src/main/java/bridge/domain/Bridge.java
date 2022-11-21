package bridge.domain;

import java.util.List;

final class Bridge {
    private final List<String> positions;

    Bridge(final List<String> positions) {
        this.positions = positions;
    }

    public int size() {
        return positions.size();
    }

    boolean isEqualAtIndex(final int index, final Position position) {
        return position == Position.from(positions.get(index));
    }
}
