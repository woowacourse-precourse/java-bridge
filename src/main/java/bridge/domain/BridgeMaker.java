package bridge.domain;

import bridge.service.constants.Move;

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
        List<String> getBridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            getBridge.add(getPassAndFail());
        }
        return getBridge;
    }

    private String getPassAndFail() {
        if (bridgeNumberGenerator.generate() == 1) {
            return Move.UP_BRIDGE.getValue();
        }
        return Move.DOWN_BRIDGE.getValue();
    }
}
