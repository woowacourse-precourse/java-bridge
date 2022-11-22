package bridge.domain;

import bridge.domain.enums.Direction;
import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = new ArrayList<>(bridge);
    }

    public boolean canCross(int position, Direction direction) {
        String command = direction.getCommand();
        return getBridgeAt(position).equals(command);
    }

    private String getBridgeAt(int position) {
        return bridge.get(position);
    }

    public int size() {
        return bridge.size();
    }
}
