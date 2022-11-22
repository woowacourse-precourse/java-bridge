package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<String>();
        for (int position = 0; position < size; position++) {
            bridge.add(getPosition());
        }
        return bridge;
    }

    public String getPosition() {
        if (this.bridgeNumberGenerator.generate() == 0) {
            return "D";
        }
        return "U";
    }
}
