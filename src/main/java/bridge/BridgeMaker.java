package bridge;

import bridge.util.UpDown;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int random = bridgeNumberGenerator.generate();
            addBridge(random, bridge);
        }

        return bridge;
    }

    private void addBridge(int random, List<String> bridge){
        addDown(random, bridge);
        addUp(random, bridge);
    }

    private void addDown(int random, List<String> bridge) {
        if (random == UpDown.DOWN.getNumber()) {
            bridge.add(UpDown.DOWN.getValue());
        }
    }

    private void addUp(int random, List<String> bridge) {
        if (random == UpDown.UP.getNumber()) {
            bridge.add(UpDown.UP.getValue());
        }
    }
}
