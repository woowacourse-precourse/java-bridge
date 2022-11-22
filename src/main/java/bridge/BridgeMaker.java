package bridge;

import bridge.standard.BridgeForm;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator numberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.numberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int generatedSize = 0; generatedSize < size; generatedSize++) {
            bridge.add(BridgeForm.transferByLayer(numberGenerator.generate()));
        }
        return bridge;
    }

}
