package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private static final int DOWN = 0;
    private static final int UP = 1;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for(int phase=0; phase<size; phase++) {
            int number = bridgeNumberGenerator.generate();
            if(number==DOWN){
                bridge.add("D");
            }
            if (number==UP) {
                bridge.add("U");
            }
        }
        return bridge;
    }
}
