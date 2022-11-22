package bridge;

import bridge.constant.BridgeDirection;

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

        for (int count = 0; count < size; count++) {
            int bridgeNumber = bridgeNumberGenerator.generate();
            bridge.add(Arrays.stream(BridgeDirection.values())
                    .filter(bridgeDirection -> bridgeNumber == bridgeDirection.getRandomNumber()).findFirst().orElse(BridgeDirection.NOTING).getMark());
        }
        return bridge;
    }
}
