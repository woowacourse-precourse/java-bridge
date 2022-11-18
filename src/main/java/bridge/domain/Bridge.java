package bridge.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }

    public int getSize() {
        return bridge.size();
    }

    public boolean isPossibleMove(int position, String direction) {
        return Objects.equals(bridge.get(position), direction);
    }
}
