package bridge.domain.bridge;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int getSize() {
        return bridge.size();
    }

    @Override
    public String toString() {
        return String.join("", bridge);
    }
}
