package bridge.Domain;

import bridge.BridgeNumberGenerator;
import bridge.Enum.BridgeGameInfo;

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
            String way = BridgeGameInfo.DOWN.getWord();
            if (bridgeNumberGenerator.generate() == 1) { way = BridgeGameInfo.UP.getWord(); }
            bridge.add(way);
        }
        return bridge;
    }
}
