package bridge;

import bridge.type.BridgeType;
import bridge.util.Message;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    public static final int COUNT_INIT = 0;

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
        for (int i = COUNT_INIT; i < size; i++) {
            int bridgeNumber = bridgeNumberGenerator.generate();
            bridge = addStringByBridgeNumber(bridge, bridgeNumber);
        }
        return bridge;
    }

    private List<String> addStringByBridgeNumber(List<String> bridge, int bridgeNumber) {
        if (bridgeNumber == BridgeType.UP.getNumberCode()) {
            bridge.add(BridgeType.UP.getCode());
        }
        if (bridgeNumber == BridgeType.DOWN.getNumberCode()) {
            bridge.add(BridgeType.DOWN.getCode());
        }
        return bridge;
    }

}
