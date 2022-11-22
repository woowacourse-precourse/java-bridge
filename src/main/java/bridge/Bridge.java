package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private List<String> bridge;

    public Bridge() {
        this.bridge = new ArrayList<>();
    }

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int getSize() {
        return bridge.size();
    }

    public List<String> getBridge() {
        return bridge;
    }

    public void connect(String side) {
        bridge.add(side);
    }

    public boolean isSameSizeWith(Bridge bridge) {
        return this.getSize() == bridge.getSize();
    }

    public boolean matchWith(Bridge bridge) {
        return this.bridge.get(this.bridge.size()-1)
                .equals(bridge.getBridge().get(this.bridge.size()-1));
    }

}
