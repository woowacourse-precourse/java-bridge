package bridge;

import java.util.List;

import static bridge.data.GameCommand.DOWN;
import static bridge.data.GameCommand.UP;

public class BridgeMaker {

    private final int DOWN_NUMBER = 0;
    private final int UP_NUMBER = 1;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        return null;
    }

    private String createCommand(int number) {
        if (number == UP_NUMBER) {
            return UP.getCommand();
        }

        return DOWN.getCommand();
    }
}
