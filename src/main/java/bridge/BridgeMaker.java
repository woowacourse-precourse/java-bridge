package bridge;

import bridge.model.constant.Message;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private static final int DOWN_NUMBER = 0;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(final BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(final int bridgeSize) {
        List<String> bridge = new ArrayList<>();
        for (int repeat = 0; repeat < bridgeSize; repeat++) {
            bridge.add(generateAnswer());
        }
        return bridge;
    }

    private String generateAnswer() {
        int generatedNumber = bridgeNumberGenerator.generate();
        if (generatedNumber == DOWN_NUMBER) {
            return Message.DOWN;
        }
        return Message.UP;
    }
}
