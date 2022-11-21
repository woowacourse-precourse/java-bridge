package bridge.model;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

    private final List<Moving> bridge;

    private Bridge(List<String> bridge) {
        this.bridge = bridge.stream()
                .map(Moving::of)
                .collect(Collectors.toList());
    }

    public static Bridge of(List<String> bridge) {
        return new Bridge(bridge);
    }

    public int size() {
        return bridge.size();
    }

    public boolean isSameMovingAt(int position, Moving moving) {
        return bridge.get(position) == moving;
    }
}
