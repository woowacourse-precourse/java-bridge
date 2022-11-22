package bridge;

import bridge.domain.constant.Command;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();

        do {
            bridge.add(makeBridgeSide());
            size--;
        } while (size > 0);
        return bridge;
    }

    private String makeBridgeSide() {
        int bridgeSide = bridgeNumberGenerator.generate();

        if (bridgeSide == 0) {
            return Command.LOWER.toString();
        }
        return Command.UPPER.toString();
    }
}
