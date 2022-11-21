package bridge;

import bridge.type.BridgeType;
import bridge.util.Message;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    public static final int BRIDGE_RANGE_MAX = 20;
    public static final int BRIDGE_RANGE_MIN = 3;
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
        validateBridgeSizeRange(size);
        List<String> bridge = new ArrayList<>();
        for (int i = COUNT_INIT; i < size; i++) {
            int bridgeNumber = bridgeNumberGenerator.generate();
            bridge = addStringByBridgeNumber(bridge, bridgeNumber);
        }
        return bridge;
    }

    public void validateBridgeSizeRange(int bridgeSize) {
        if (bridgeSize > BRIDGE_RANGE_MAX || bridgeSize < BRIDGE_RANGE_MIN) {
            throw new IllegalArgumentException(Message.ERROR_BRIDGE_SIZE_RANGE.getMessage());
        }
    }

    private List<String> addStringByBridgeNumber(List<String> bridge, int bridgeNumber) {
        if (bridgeNumber == BridgeType.UP.getIntCode()) {
            bridge.add(BridgeType.UP.getStringCode());
        }
        if (bridgeNumber == BridgeType.DOWN.getIntCode()) {
            bridge.add(BridgeType.DOWN.getStringCode());
        }
        return bridge;
    }

}
