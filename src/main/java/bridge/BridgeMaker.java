package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private List<String> bridge;
    private BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        bridge = new ArrayList<>();
        makeBridgeBlock(size);
        return bridge;
    }

    public void makeBridgeBlock(int size) {
        for (int i = 0; i < size; i++) {
            String randomNumber = String.valueOf(bridgeNumberGenerator.generate());
            if (randomNumber.equals("0")) {
                bridge.add("D");
                continue;
            }
            bridge.add("U");
        }
    }

    public StringBuilder makeInitialBridge() {
        String bridgeFrame = "[ ]";
        StringBuilder initialBridge = new StringBuilder(bridgeFrame);
        return initialBridge;
    }
}