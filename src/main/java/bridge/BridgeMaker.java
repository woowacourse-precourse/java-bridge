package bridge;

import bridge.util.validator.BridgeNumberValidator;

import java.util.ArrayList;
import java.util.List;

import static bridge.util.constants.MovableSpace.UPPER_SPACE;
import static bridge.util.constants.MovableSpace.LOWER_SPACE;
import static bridge.util.constants.BridgeConstant.UPPER_BRIDGE_NUMBER;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int count = 0; count < size; count++) {
            int bridgeNumber = bridgeNumberGenerator.generate();
            addMovableSpace(bridge, bridgeNumber);
        }
        return bridge;
    }

    private void addMovableSpace(List<String> bridge, int bridgeNumber) {
        BridgeNumberValidator.validate(bridgeNumber);
        if (bridgeNumber == UPPER_BRIDGE_NUMBER.getValue()) {
            bridge.add(UPPER_SPACE.getValue());
            return;
        }
        bridge.add(LOWER_SPACE.getValue());
    }
}
