package bridge;

import bridge.constant.BridgeStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        List<BridgeStatus> bridgeStatus = Arrays.asList(BridgeStatus.values());
        for(int i = 0; i < size; i++) {
            bridge.add(
                    bridgeStatus.get(bridgeNumberGenerator.generate()).getStatus()
            );
        }
        return bridge;
    }
}
