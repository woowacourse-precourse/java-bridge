package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    private Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public static Bridge make(int size) {
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new Bridge(maker.makeBridge(size));
    }
}
