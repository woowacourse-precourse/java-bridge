package bridge;

import bridge.Utils.MoveType;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int num = bridgeNumberGenerator.generate();
            String upOrDown = isUpOrDown(num);
            bridge.add(upOrDown);
        }
        return bridge;
    }

    public String isUpOrDown(int num) {
        if (num == 1) {
            return MoveType.UP.getStrValue();
        }
        return MoveType.DOWN.getStrValue();
    }
}
