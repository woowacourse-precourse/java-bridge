package bridge;

import bridge.BridgeNumberGenerator;
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
            bridge.add(GeneratorToBridge(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }

    public String GeneratorToBridge(int number){
        if(number == 1){
            return "U";
        }
        return "D";
    }
}