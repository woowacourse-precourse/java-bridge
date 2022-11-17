package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private static final int DOWN = 0;
    private static final int UP = 1;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int number = bridgeNumberGenerator.generate();
            addBridge(bridge, number);
        }
        return bridge;
    }

    private void addBridge(List<String> bridge, int number) {
        if (number == DOWN) {
            bridge.add(InputType.MOVE_DOWN_COMMAND.getCommand());
            return;
        }

        if (number == UP) {
            bridge.add(InputType.MOVE_UP_COMMAND.getCommand());
            return;
        }
    }
}
