package bridge.model;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    private final List<Moving> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = toDirection(bridge);
    }

    private List<Moving> toDirection(List<String> bridge) {
        return bridge.stream().map(Moving::fromInput).collect(Collectors.toList());
    }

    public boolean isBroken(int position, Moving moving) {
        return bridge.get(position) != moving;
    }

    public boolean isEnded(int position) {
        return bridge.size() - 1 == position;
    }
}
