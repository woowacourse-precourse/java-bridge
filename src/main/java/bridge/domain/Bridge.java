package bridge.domain;

import bridge.domain.enums.Direction;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean canCross(int position, Direction direction) {
        return getBridgeAt(position).equals(direction.getCommand());
    }

    private String getBridgeAt(int position) {
        return bridge.get(position);
    }

    public int size() {
        return bridge.size();
    }
}
