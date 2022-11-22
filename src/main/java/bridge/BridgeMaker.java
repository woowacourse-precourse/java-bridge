package bridge;

import bridge.Constant.BridgeSelection;

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
            int randomBLock = bridgeNumberGenerator.generate();
            if (randomBLock == 1) bridge.add(BridgeSelection.Up.get());
            if (randomBLock == 0) bridge.add(BridgeSelection.Down.get());
        }
        return bridge;
    }
}