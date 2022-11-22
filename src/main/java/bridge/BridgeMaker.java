package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(pushUpDown(bridgeNumberGenerator.generate()));
        }
        return result;
    }

    private String pushUpDown(int randomNumber) {
        if (randomNumber == 1) {
            return "U";
        }
        return "D";
    }
}
