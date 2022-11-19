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
        int random;
         for (int i = 0; i < size; i++) {
             random = bridgeNumberGenerator.generate();
             if (random == 1) {
                 result.add("U");
             } else if (random == 0) {
                 result.add("D");
             }
         }
         return result;
    }
}
