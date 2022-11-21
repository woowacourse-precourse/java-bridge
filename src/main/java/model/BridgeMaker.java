package model;

import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for(int i=0; i<size; i++) {
            bridge.add(makeEachBridge());
        }
        System.out.println(bridge);
        return bridge;
    }

    public String makeEachBridge() {
        if(bridgeNumberGenerator.generate() == 1) {
            return "U";
        }
        return "D";
    }
}
