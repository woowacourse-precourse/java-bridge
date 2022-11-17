package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;

public class Bridge {

    private final int size;
    private List<String> bridge;

    public Bridge(int size) {
        this.size = size;
        makeBridgeBySize(size);
    }

    private void makeBridgeBySize(int size){
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
    }

}
