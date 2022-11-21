package bridge.Model;

import bridge.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int count = 0; count < size; count++) {
            int number = bridgeNumberGenerator.generate();
            bridge.add(changeValue(number));
        }
        return bridge;
    }

    private String changeValue(int number) {
        if(number == 1)
            return "U";
        return "D";
    }
}
