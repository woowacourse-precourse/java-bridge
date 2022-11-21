package domain;

import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;


public class BridgeMaker {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }


    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size ; i++){
            int num = bridgeNumberGenerator.generate();
            if (num == 1 ) { bridge.add(UP); }
            if (num == 0 ) { bridge.add(DOWN); }
        }
        return bridge;
    }
}
