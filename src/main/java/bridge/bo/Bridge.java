package bridge.bo;

import java.util.Iterator;
import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public Iterator<String> getIterator() {
        return bridge.iterator();
    }
}
