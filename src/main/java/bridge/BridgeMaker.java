package bridge;

import bridge.enums.Glass;
import java.util.ArrayList;
import java.util.List;


public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    protected BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    protected List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<String>();
        for(int idx=0; idx<size; idx++){
            Integer direction = bridgeNumberGenerator.generate();
            bridge.add(Glass.glassOf(direction).MOVE());
        }
        return bridge;
    }
}
