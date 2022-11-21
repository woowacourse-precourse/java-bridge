package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for(int phase=0; phase<size; phase++) {
            int number = bridgeNumberGenerator.generate();
            if(number==0){
                bridge.add("D");
            } else if (number==1) {
                bridge.add("U");
            }
        }
        return bridge;
    }
}
