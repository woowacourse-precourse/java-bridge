package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public String convertRandomNumber(int randomNumber) {
        if (randomNumber == 0) {
            return "D";
        }
        return "U";
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridge.add(convertRandomNumber(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }
}
