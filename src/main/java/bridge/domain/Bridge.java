package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public boolean isMovable(String move, int location) {
        return bridge.get(location).equals(move);
    }

    public int size(){
        return bridge.size();
    }
}
