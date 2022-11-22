package bridge.model;

import bridge.BridgeNumberGenerator;
import bridge.view.Constants;

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
        for(int i=Constants.ZERO; i<size; i++) {
            bridge.add(makeEachBridge());
        }
        return bridge;
    }

    public String makeEachBridge() {
        if(bridgeNumberGenerator.generate() == Constants.ONE) {
            return Constants.UP;
        }
        return Constants.DOWN;
    }
}
