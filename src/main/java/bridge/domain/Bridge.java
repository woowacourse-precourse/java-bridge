package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> copyBridge() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < bridge.size(); i++) {
            list.add(bridge.get(i));
        }
        return list;
    }

    @Override
    public String toString() {
        return bridge.toString();
    }
}
