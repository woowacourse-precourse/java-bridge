package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.controller.BridgeMaker;

import java.util.List;

public class Bridge {
    private final int size;
    private final List<String> result;

    public Bridge(int size) {
        this.size = size;
        this.result = makeBridge(size);
    }

    public List<String> makeBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridgeResult = bridgeMaker.makeBridge(size);
        return bridgeResult;
    }
}
