package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.commom.constant.LocationTable.getKeyWithIndex;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int space = 0; space < size; space++) {
            int index = bridgeNumberGenerator.generate();
            String status = getKeyWithIndex(index);
            bridge.add(space, status);
        }

        return bridge;
    }
}
