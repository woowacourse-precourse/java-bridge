package bridge.model;

import bridge.domain.Bridge2DMaker;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class Bridge {

    private final String[][] bridge;

    public Bridge(int size) {
        List<String> bridge1D = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
        this.bridge = new Bridge2DMaker().make2DBridge(bridge1D);
    }

    public String[][] getBridge() {
        return this.bridge;
    }
}
