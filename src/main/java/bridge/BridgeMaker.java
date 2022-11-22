package bridge;

import bridge.BridgeNumberGenerator;
import bridge.util.DataTypeChanger;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;
    DataTypeChanger dataTypeChanger = new DataTypeChanger();

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridge.add(dataTypeChanger.convertToUpOrDown(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }
}
