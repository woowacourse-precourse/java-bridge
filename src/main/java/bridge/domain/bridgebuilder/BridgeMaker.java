package bridge.domain.bridgebuilder;

import bridge.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        return BridgeConverter.createRealBridge(makeBinaryBridge(size, new ArrayList<>()));
    }

    private List<Integer> makeBinaryBridge(int size, List<Integer> bridge) {
        for (int i = 0; i < size; i++) {
            bridge.add(bridgeNumberGenerator.generate());
        }
        return bridge;
    }
}
