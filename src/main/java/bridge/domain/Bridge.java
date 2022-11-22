package bridge.domain;

import java.util.List;

public class Bridge {
    List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public String get(Integer index) {
        return bridge.get(index);
    }

    public Integer size() {
        return bridge.size();
    }
}
