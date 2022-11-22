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
        List<String> bridge = new ArrayList<>();
        for (Integer unit : numberBridge(size)) {
            if (unit == 1) {bridge.add("U");}
            if (unit == 0) {bridge.add("D");}
        }//for
        return bridge;
    }//makeBridge

    private List<Integer> numberBridge(int size) {
        List<Integer> bridge = new ArrayList<>();
        for (int sizeCount = 0; sizeCount < size; sizeCount++) {
            bridge.add(bridgeNumberGenerator.generate());
        }//for
        return bridge;
    }// numberBridge
}//end class
