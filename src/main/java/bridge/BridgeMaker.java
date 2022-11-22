package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Integer bridgeNumber = bridgeNumberGenerator.generate();
            String bridgeCharacter = bridgeNumberToBridgeCharacter(bridgeNumber);
            bridge.add(bridgeCharacter);
        }
        return bridge;
    }

    public String bridgeNumberToBridgeCharacter(Integer bridgeNumber) {
        for (BridgeStatus status : BridgeStatus.values()) {
            if (status.getBridgeNumber().equals(bridgeNumber)) {
                return status.getBridgeCharacter();
            }
        }
        return null;
    }
}
