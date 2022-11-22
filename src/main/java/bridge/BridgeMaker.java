package bridge;

import bridge.constant.Game;

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
            String upDown = judgeUporDown(bridgeNumberGenerator.generate());
            bridge.add(upDown);
        }
        return bridge;
    }

    private String judgeUporDown(int number) {
        if(number == 0) return Game.BRIDGE_GENERATE_DOWN;
        return Game.BRIDGE_GENERATE_UP;
    }
}
