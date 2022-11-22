package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> copyBridge() {
        return new ArrayList<>(bridge);
    }

    public boolean checkTheBridge(String s) {
        return bridge.get(0).equals(s);
    }

    public void passToTheNextSpace() {
        bridge.remove(0);
    }

    public int getSize() {
        return bridge.size();
    }

    @Override
    public String toString() {
        return bridge.toString();
    }
}
