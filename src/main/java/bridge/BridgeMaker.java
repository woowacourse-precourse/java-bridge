package bridge;

import java.util.ArrayList;
import java.util.List;


public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < size ; i++) {
            list.add("D");
            if(bridgeNumberGenerator.generate() == 1) {
                list.set(i, "U");
            }
        }
        return list;
    }
}
