package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getSize() {
        return bridge.size();
    }

    private String getElement(int index) {
        return bridge.get(index);
    }

}
