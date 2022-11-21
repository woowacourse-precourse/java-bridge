package bridge.model;

import bridge.constant.Game;
import bridge.utils.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            if(bridgeNumberGenerator.generate() == 0) {
                bridge.add(Game.BRIDGE_GENERATE_DOWN);
                continue;
            }
            bridge.add(Game.BRIDGE_GENERATE_UP);
        }
        return bridge;
    }
}
