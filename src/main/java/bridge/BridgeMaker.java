package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            int generatedNum = bridgeNumberGenerator.generate();
            bridge.add(checkGenerate(generatedNum));
        }
        return bridge;
    }

    private String checkGenerate(int generatedNum) {
        if (generatedNum == 0) {
            return "D";
        }
        return "U";
    }
}
