package bridge;

import bridge.utils.converter.ConvertBridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private final ConvertBridge convertBridge;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
        this.convertBridge = new ConvertBridge();
    }

    public List<String> makeBridge(int size) {
        int count = size;
        List<String> bridge = new ArrayList<>();
        while (count != 0) {
            int number = bridgeNumberGenerator.generate();
            String footHold = convertBridge.toUpOrDown(number);
            bridge.add(footHold);
            count --;
        }
        return bridge;
    }
}
