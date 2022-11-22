package bridge.provider;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(final int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String direction = addMoving(bridgeNumberGenerator.generate());
            bridge.add(direction);
        }
        return bridge;
    }

    public String addMoving(final int bridgeNumber) {
        if (bridgeNumber == 0) {
            return "D";
        }
        return "U";
    }
}
