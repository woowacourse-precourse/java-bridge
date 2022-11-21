package bridge.domain;

import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeMaker {
    public static final String UP = "U";
    public static final String DOWN = "D";
    public static final int UP_NUMBER = 1;
    public static final int DOWN_NUMBER = 0;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridge.add(convertNumberToDirection(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }

    public String convertNumberToDirection(int generatedNum) {
        return Arrays.stream(Direction.values())
                .filter(d -> d.getNum() == generatedNum)
                .findFirst().get()
                .getValue();
    }
}
