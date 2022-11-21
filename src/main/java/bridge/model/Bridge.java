package bridge.model;

import bridge.domain.Bridge2DMaker;
import bridge.domain.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class Bridge {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    Bridge2DMaker bridge2DMaker = new Bridge2DMaker();
    private final String[][] bridge;

    public Bridge(int size) {
        List<String> bridge1D = bridgeMaker.makeBridge(size);
        this.bridge = bridge2DMaker.make2DBridge(bridge1D);
    }

    public String[][] getBridge() {
        return this.bridge;
    }


}
