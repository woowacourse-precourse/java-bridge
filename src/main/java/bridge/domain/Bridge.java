package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean hasNextTileThatPosition(int position, String spaceToMove) {
        return bridge.get(position).equals(spaceToMove);
    }

    public boolean isLastPosition(int position) {
        return bridge.size() == position;
    }
}
