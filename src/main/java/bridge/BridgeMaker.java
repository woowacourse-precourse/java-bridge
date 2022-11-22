package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.Constants.*;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        return addBridgeArrow(bridge, size);
    }

    private List<String> addBridgeArrow(List<String> bridge, int size) {
        while (size-- > 0) {
            int bridgeRandomNumber = bridgeNumberGenerator.generate();
            bridge.add(convertBridgeRandomNumberToUpDownMark(bridgeRandomNumber));
        }
        return bridge;
    }

    private String convertBridgeRandomNumberToUpDownMark(int bridgeRandomNumber) {
        if (bridgeRandomNumber == BRIDGE_DOWN_NUMBER) {
            return DOWN;
        }
        return UP;
    }
}
