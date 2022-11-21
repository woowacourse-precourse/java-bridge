package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isMovable(String move, int location) {
        return bridge.get(location).equals(move);
    }

    public int size(){
        return bridge.size();
    }

    public static Bridge generateBridge(int bridgeSize){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }
}
