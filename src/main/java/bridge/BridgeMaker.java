package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.constant.Constants.DOWN_COMMAND;
import static bridge.constant.Constants.UP_COMMAND;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int number = bridgeNumberGenerator.generate();
            if (number == 0) {
                bridge.add(DOWN_COMMAND);
            } else if (number == 1) {
                bridge.add(UP_COMMAND);
            }
        }
        return bridge;
    }
}
