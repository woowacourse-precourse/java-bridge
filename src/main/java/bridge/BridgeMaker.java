package bridge;

import bridge.utils.Stairs;
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
            int randomValue = bridgeNumberGenerator.generate();
            String upOrDown = Stairs.convertIntToStr(randomValue);
            bridge.add(upOrDown);
        }
        return bridge;
    }
}
