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
        List<String> Bridge = new ArrayList<>();
        loopAddBridge(Bridge, size);
        return Bridge;
    }

    public void loopAddBridge(List<String> Bridge, int size) {
        for (int i = 0; i < size; i++) {
            int bridgeNumber = generateBridge();
            addBridge(Bridge, bridgeNumber);
        }
    }

    public void addBridge(List<String> Bridge, int bridgeNumber) {
        if (bridgeNumber == 0) {
            Bridge.add("D");
        }
        if (bridgeNumber == 1) {
            Bridge.add("U");
        }
    }

    public int generateBridge() {
        return this.bridgeNumberGenerator.generate();
    }
}
