package bridge.vo;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = Collections.unmodifiableList(bridge);
    }

    public Iterator<String> toIterator() {
        return bridge.iterator();
    }
}
