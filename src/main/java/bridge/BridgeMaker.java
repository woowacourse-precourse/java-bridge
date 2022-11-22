package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.bridge.BridgeBlock.*;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> randomBridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randomBridge.add(generateRandomUpAndDownNum());
        }
        return randomBridge;
    }

    private String generateRandomUpAndDownNum() {
        return convertTypeString(bridgeNumberGenerator.generate());
    }
}
