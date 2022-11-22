package bridge;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(int bridgeSize) {
        this.bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
    }

    public List<String> getBridge() {
        return bridge;
    }

}
