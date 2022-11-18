package bridge.service;

import bridge.constant.Constant;
import bridge.domain.Direction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = Constant.INITIAL_NUMBER; i<size; i++){
            bridge.add(Direction.findMark(bridgeNumberGenerator.generate()));
        }
        return Collections.unmodifiableList(bridge);
    }
}
