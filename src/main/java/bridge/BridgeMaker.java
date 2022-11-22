package bridge;

import bridge.domain.resources.converter.ConvertBridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        while (size != 0) {
            int number = bridgeNumberGenerator.generate();
            String footHold = ConvertBridge.toUpOrDown(number);
            bridge.add(footHold);
            size--;
        }
        System.out.println("bridge = " + bridge);
        return bridge;
    }
}
