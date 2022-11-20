package bridge.util;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.bridge.BridgeBlock.*;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int bridgeSize) {
        List<String> randomBridge = new ArrayList<>();
        for (int i = 0; i < bridgeSize; i++) {
            randomBridge.add(convertType(bridgeNumberGenerator.generate()));
        }
        return randomBridge;
    }
}
