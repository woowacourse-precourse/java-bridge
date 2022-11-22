package bridge;

import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<String>();
        while (size-- > 0) {
            bridge.add(getMove(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }

    private String getMove(int randomNum) {
        if (randomNum == 0) {
            return "D";
        }
        return "U";
    }
}
