package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> trueBridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            trueBridge.add(addTile());
        }
        return trueBridge;
    }

    public String addTile() {
        if (bridgeNumberGenerator.generate() == 0) {
            return "D";
        }
        return "U";
    }
}
