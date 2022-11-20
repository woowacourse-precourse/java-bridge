package bridge.model;

import bridge.BridgeRandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private BridgeMaker bridgeMaker;
    private final List<String> bridge = new ArrayList<>();

    public Bridge(int size) {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = this.bridgeMaker.makeBridge(size);
        this.bridge.addAll(bridge);
    }
}
