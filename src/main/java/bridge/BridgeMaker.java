package bridge;

import java.util.ArrayList;
import java.util.List;

import bridge.constant.Direction;

public class BridgeMaker {

    private static final int MINIMUM_SIZE = 3;
    private static final int MAXIMUM_SIZE = 20;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        validateSize(size);
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int bridgeNumber = bridgeNumberGenerator.generate();
            bridge.add(getCapitalLetterFor(bridgeNumber));
        }
        return bridge;
    }

    private void validateSize(int size) {
        if (size < MINIMUM_SIZE) {
            throw new IllegalArgumentException("다리 길이는 " + MINIMUM_SIZE + "이상입니다");
        }
        if (size > MAXIMUM_SIZE) {
            throw new IllegalArgumentException("다리 길이는 " + MAXIMUM_SIZE + "이하입니다");
        }
    }

    private String getCapitalLetterFor(int bridgeNumber) {
        return Direction.from(bridgeNumber)
                .capitalLetter();
    }
}
