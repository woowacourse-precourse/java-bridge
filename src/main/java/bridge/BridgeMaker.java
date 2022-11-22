package bridge;

import enumCollections.Side;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int bridgeIndex = 0; bridgeIndex < size; bridgeIndex++) {
            int randomNumber = bridgeNumberGenerator.generate();
            String side = Side.getBridgeSavingFormat(randomNumber);
            bridge.add(side);
        }
        return bridge;
    }
}