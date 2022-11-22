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
        if (bridgeNumberGenerator instanceof BridgeNumberGenerator) {
            makeBridgeByBridgeNumberGenerator(size);
        }
        return bridge;
    }

    public void makeBridgeByBridgeNumberGenerator(int size) {
        bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String randomNumber = String.valueOf(bridgeNumberGenerator.generate());
            makeBridgeBlock(randomNumber);
        }
    }

    public List<String> makeBridgeByBridgeRandomNumberGenerator(int size) {
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String randomNumber = String.valueOf(bridgeNumberGenerator.generate());
            makeBridgeBlock(randomNumber);
        }
        return bridge;
    }

    public void makeBridgeBlock(String randomNumber) {
        if (randomNumber.equals("0")) {
            bridge.add("D");
        }
        if (randomNumber.equals("1")) {
            bridge.add("U");
        }
    }
}