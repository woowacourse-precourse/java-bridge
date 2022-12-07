package bridge.model;

import java.util.Collections;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge (List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge () {
        return Collections.unmodifiableList(bridge);
    }

    public int getSize() {
        return bridge.size();
    }

    public Boolean isExist(int index, String direction) {
        String validBridge = bridge.get(index);
        return validBridge.equals(direction);
    }
}