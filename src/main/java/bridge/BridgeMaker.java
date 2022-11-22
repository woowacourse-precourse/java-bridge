package bridge;

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
            int bridgeNumber = bridgeNumberGenerator.generate();
            if (bridgeNumber == MovingEnum.U.getNum()) {
                bridge.add(MovingEnum.U.name());
            }
            if (bridgeNumber == MovingEnum.D.getNum()) {
                bridge.add(MovingEnum.D.name());
            }
        }
        return bridge;
    }
}
