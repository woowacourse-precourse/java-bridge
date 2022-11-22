package bridge.domain;


import java.util.List;

public class Bridge {

    private final List<String> bridge;


    public Bridge(final List<String> bridge) {
        this.bridge = bridge;
    }

    public String getBridgeByIndex(int index) {
        return bridge.get(index);
    }

    public int getBridgeSize() {
        return bridge.size();
    }
}
