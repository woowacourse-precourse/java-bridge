package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bridge {
    private final List<BridgeElement> bridge;
    private int pivot = 0;

    public Bridge(List<String> bridge) {
        this.bridge = new ArrayList<>(bridge)
                .stream()
                .map(BridgeElement::new)
                .collect(Collectors.toList());
    }

    public BridgeElement next() {
        return bridge.get(pivot++);
    }

    public void reset() {
        pivot = 0;
    }
}
