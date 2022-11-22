package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int getSize() {
        return bridge.size();
    }

    public String getValue(int index) {
        return bridge.get(index);
    }

    public boolean isEquals(Position position, int index) {
        return position.getCommand().equals(bridge.get(index));
    }
}
