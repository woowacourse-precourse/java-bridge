package bridge.domain.bridge;

import java.util.List;

public class Bridge {
    List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int getSize() {
        return bridge.size();
    }

    public boolean isSameBlock(int index, String direction) {
        return bridge.get(index).equals(direction);
    }

    @Override
    public String toString() {
        return String.join("", bridge);
    }
}
