package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        Map<Integer, String> crossBridge = initCrossBridge();

        for (int i = 0; i < size; i++) {
            int commandNumber = bridgeNumberGenerator.generate();
            bridge.add(crossBridge.get(commandNumber));
        }
        return bridge;
    }

    private Map<Integer, String> initCrossBridge() {
        Map<Integer, String> crossBridge = new HashMap<>();
        crossBridge.put(0,"D");
        crossBridge.put(1, "U");

        return crossBridge;
    }
}
