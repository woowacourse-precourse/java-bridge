package bridge;

import bridge.input.InputString;

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

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int generate = bridgeNumberGenerator.generate();
            if (generate == 0) {
                bridge.add(InputString.DOWN);
                continue;
            }
            bridge.add(InputString.UP);
        }
        return bridge;
    }
}
