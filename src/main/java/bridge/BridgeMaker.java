package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static bridge.Enums.View.LOWER_POSITION;
import static bridge.Enums.View.UPPER_POSITION;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        Map<Integer, String> pathMap = new HashMap<>();
        pathMap.put(0, LOWER_POSITION.toString());
        pathMap.put(1, UPPER_POSITION.toString());

        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();
            bridge.add(pathMap.get(randomNumber));
        }

        return bridge;
    }

}
