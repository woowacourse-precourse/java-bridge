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
            bridge.add(getAvailablePosition(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }

    public String getAvailablePosition(int positionNumber) {
        return Side.getBridgeSavingFormat(positionNumber);
    }
}
