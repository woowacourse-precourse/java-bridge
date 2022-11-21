package bridge;

import bridge.resource.ErrorType;
import bridge.resource.InputType;
import bridge.view.Error;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private static final int MIN_BRIDGE_LENGTH = 3;
    private static final int MAX_BRIDGE_LENGTH = 20;
    private static final int DOWN = 0;
    private static final int UP = 1;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        validateSize(size);
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

    private static void validateSize(int size) {
        if (size < MIN_BRIDGE_LENGTH || size > MAX_BRIDGE_LENGTH)
            Error.printException(ErrorType.RANGE);
    }

}
