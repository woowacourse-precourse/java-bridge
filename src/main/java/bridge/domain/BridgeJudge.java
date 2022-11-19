package bridge.domain;

import java.util.Collections;
import java.util.List;

public class BridgeJudge {

    private List<String> bridge;

    public void addBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }


}
