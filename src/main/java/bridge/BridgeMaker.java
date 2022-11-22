package bridge;

import bridge.BridgeNumberGenerator;
import bridge.domain.BridgeShape;

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
            BridgeShape bridgeShape = BridgeShape.findByNumber(bridgeNumberGenerator.generate());
            bridge.add(bridgeShape.getKeyword());
        }
        return bridge;
    }

}
