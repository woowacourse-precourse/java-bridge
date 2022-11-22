package bridge;

import bridge.type.BridgeType;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            bridge.add(BridgeType.findNameByNumber(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }
}
