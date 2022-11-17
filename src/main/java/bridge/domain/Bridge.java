package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean canMove(int position, String spaceToMove) {
        return bridge.get(position).equals(spaceToMove);
    }
}
