package bridge.domain;

import java.util.Collections;
import java.util.List;

public class Bridge {

    private final List<String> bridges;

    public Bridge(List<String> bridges) {
        this.bridges = bridges;
    }

    public int getCount() {
        return bridges.size();
    }

    public List<String> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
