package bridge.domain;

import bridge.BridgeMaker;
import java.util.List;

public class Bridge {
    private int size;
    private List<String> bridgeStatus;

    public Bridge(int size, BridgeMaker bridgeMaker) {
        this.size = size;
        this.bridgeStatus = bridgeMaker.makeBridge(size);
    }
}
