package bridge.model;

import bridge.model.message.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
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
            return Message.GO_DOWN.getMessage();
        }
        return Message.GO_UP.getMessage();
    }
}
