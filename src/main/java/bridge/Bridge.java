package bridge;

import java.util.List;

public class Bridge {
    int size;
    List<String> bridge;

    public Bridge(int size) {
        BridgeNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomNumberGenerator);
        this.size = size;
        bridge = bridgeMaker.makeBridge(this.size);
    }
}
