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
        validateBridge(bridge);
        this.bridge.addAll(bridge);
    }

    public List<String> getBridge() {
        return bridge;
    }

    private void validateBridge(List<String> bridge) {
        for (String space : bridge) {
            if (!space.equals(BridgeSpace.UP.getValue()) && !space.equals(BridgeSpace.DOWN.getValue())) {
                throw new IllegalStateException();
            }
        }
    }
}
