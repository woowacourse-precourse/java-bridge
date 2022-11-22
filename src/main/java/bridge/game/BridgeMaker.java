package bridge.game;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        NumberConvertor numberConvertor = new NumberConvertor();
        List<String> bridge = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            int number = bridgeNumberGenerator.generate();
            String upOrDown = numberConvertor.convert(number);
            bridge.add(i, upOrDown);
        }
        return bridge;
    }
}
