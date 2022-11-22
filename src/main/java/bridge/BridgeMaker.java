package bridge;

import model.BridgeSize;
import type.BridgeType;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(BridgeSize size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; !size.isEqual(i); i++) {
            bridge.add(BridgeType.findNameByNumber(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }
}
