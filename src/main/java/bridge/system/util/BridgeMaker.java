package bridge.system.util;

import bridge.domain.BridgePhase;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.BridgePhase.*;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> randomBridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randomBridge.add(convertBridgeMessage(bridgeNumberGenerator.generate()));
        }
        return randomBridge;
    }
}
