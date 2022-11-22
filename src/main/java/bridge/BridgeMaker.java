package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    public static final int BRIDGE_COUNT = 2;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(BridgeLength bridgeLength) {
        return new ArrayList<>(bridgeLength.getBridgeLength());
    }

    public List<Bridge> makeBridges(BridgeLength bridgeLength) {
        List<Bridge> bridgeLines = new ArrayList<>();
        for (int i = 0; i < BRIDGE_COUNT; i++) {
            bridgeLines.add(new Bridge(makeBridge(bridgeLength)));
        }
        return bridgeLines;
    }

    public BridgeNumberGenerator getBridgeNumberGenerator() {
        return bridgeNumberGenerator;
    }

}
