package bridge.vo;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Bridge {
    private final List<BridgeStep> bridge;

    public Bridge(List<BridgeStep> bridge) {
        this.bridge = Collections.unmodifiableList(bridge);
    }

    public Iterator<BridgeStep> toIterator() {
        return bridge.iterator();
    }
}
