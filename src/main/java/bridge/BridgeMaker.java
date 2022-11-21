package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BridgeMaker {
    public static HashMap<Integer, String> generateDict = new HashMap<>();
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
        generateDict.put(1,"U");
        generateDict.put(0,"D");
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i=0; i<size; i++) {
            bridge.add(generateDict.get(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }
}
