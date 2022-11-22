package bridge.domain;

import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeMaker {
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
