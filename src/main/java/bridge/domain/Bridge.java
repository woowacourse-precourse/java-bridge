package bridge.domain;

import bridge.constant.UpDownConstant;
import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge() {
        this.bridge = new ArrayList<>();
    }

    public Bridge(final List<String> bridge) {
        this.bridge = bridge;
    }

    public void addBridge(UpDownConstant upDownConstant) {
        bridge.add(upDownConstant.getSymbol());
    }

    public String valueAt(int idx) {
        return bridge.get(idx);
    }

    public int length() {
        return bridge.size();
    }

    public boolean equalsLast(Bridge compareBridge) {
        int idx = length() - 1;
        return valueAt(idx) == compareBridge.valueAt(idx);
    }

    public boolean equalsLength(Bridge compareBridge) {
        return length() == compareBridge.length();
    }
}
