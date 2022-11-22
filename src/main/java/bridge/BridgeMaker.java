package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();

        for(int i = 0; i < size; i++){
            if(bridgeNumberGenerator.generate() == 1) {
                bridge.add("U");
                continue;
            }
            bridge.add("D");
        }
        return bridge;
    }
}
