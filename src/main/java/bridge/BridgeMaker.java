package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private final RandomNumberHandler randomNumberHandler;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator, RandomNumberHandler randomNumberHandler) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
        this.randomNumberHandler = randomNumberHandler;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridge.add(randomNumberHandler.convertRandomNumber(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }
}
