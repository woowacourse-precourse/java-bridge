package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeMaker;

import java.util.List;

public class Bridge {
    private final int size;
    private final List<String> result;

    public Bridge(int size) {
        this.size = size;
        this.result = makeBridge(size);
    }

    public int getSize() {
        return size;
    }

    public String getIndexResult(int index) {
        return result.get(index);
    }

    public List<String> makeBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridgeResult = bridgeMaker.makeBridge(size);
        return bridgeResult;
    }
}
