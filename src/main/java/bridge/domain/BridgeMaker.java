package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import bridge.domain.strategy.BridgeNumberGenerator;

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
            int randomNumber = bridgeNumberGenerator.generate();

            if (randomNumber == 0) {
                bridge.add("D");
                continue;
            }
            bridge.add("U");
        }
        return bridge;
    }
}
