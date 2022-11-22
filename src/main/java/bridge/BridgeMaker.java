package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    Bridge bridge = new Bridge();

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public void startMakeBridge(int size) {
        List<String> tmpBridgeShape = makeBridge(size);
        bridge.setBridgeAnswer(tmpBridgeShape);
    }

    public List<String> makeBridge(int size) {
        List<String> bridgeShape = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int bridgeValue = bridgeNumberGenerator.generate();
            bridgeShape.add(numberToString(bridgeValue));
        }
        Bridge bridge = new Bridge(bridgeShape);
        return bridgeShape;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public String numberToString(int number) {
        if (number == 1)
            return Constant.UP;
        return Constant.DOWN;
    }
}
