package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private static final int UP = 1;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridgeMap = new ArrayList<>();

        for (int i = 0; i < size; ++i) {
            String cell = makeBridgeCell(bridgeNumberGenerator.generate());
            bridgeMap.add(cell);
        }
        return bridgeMap;
    }

    private String makeBridgeCell(int cell) {
        if (cell == UP) {
            return BridgeGame.CMD_UP;
        }
        return BridgeGame.CMD_DOWN;
    }
}
