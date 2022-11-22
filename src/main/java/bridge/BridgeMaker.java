package bridge;

import bridge.BridgeNumberGenerator;
import static bridge.util.ConvertData.mappingBridgeCellIntToString;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();

        for (int iter = 0; iter < size; iter++) {
            int number = bridgeNumberGenerator.generate();
            String value = mappingBridgeCellIntToString(number);
            bridge.add(value);
        }

        return bridge;
    }
}
