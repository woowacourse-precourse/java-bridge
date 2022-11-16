package bridge;

import java.util.ArrayList;
import java.util.List;

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
        List<Integer> temporaryBridge = new ArrayList<>();
        for (int length = 0; length < size; length++) {
            temporaryBridge.add(bridgeNumberGenerator.generate());
        }
        List<String> bridge = compareBridge(temporaryBridge);
        return bridge;
    }

    public List<String> compareBridge(List<Integer> temporaryBridge) {
        List<String> bridge = new ArrayList<>();
        for (int idx = 0; idx < temporaryBridge.size(); idx++) {
            if (temporaryBridge.get(idx) == 0) {
                bridge.add("D");
                continue;
            }
            bridge.add("U");
        }
        return bridge;
    }
}
