package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge implements Cloneable {
    private List<String> bridge = new ArrayList<>();

    Bridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(size);
    }

    Bridge() {

    }

    public void addBridge(String input) {
        bridge.add(new String(input));
    }

    public String get(int idx) {
        return bridge.get(idx);
    }


    public int size() {
        return bridge.size();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
