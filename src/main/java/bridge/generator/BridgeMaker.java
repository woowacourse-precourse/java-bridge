package bridge.generator;

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
            int status = bridgeNumberGenerator.generate();
            AreaStatus areaStatus = AreaStatus.getAreaStatus(status);
            bridge.add(areaStatus.getSymbol());
        }
        return bridge;
    }
}
