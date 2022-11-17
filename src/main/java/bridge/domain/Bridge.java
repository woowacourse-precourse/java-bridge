package bridge.domain;

import java.util.List;
import java.util.Objects;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isPossibleMove(int position, String direction) {
        return Objects.equals(bridge.get(position), direction);
    }
}
