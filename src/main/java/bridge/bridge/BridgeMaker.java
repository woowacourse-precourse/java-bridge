package bridge.bridge;

import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    public static final String UP_BRIDGE_PHRASE = "U";
    public static final String DOWN_BRIDGE_PHRASE = "D";
    private static final int DOWN_BRIDGE_NUMBER = 0;
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
        for (int makeBridgeIndex = 1; makeBridgeIndex <= size; makeBridgeIndex++) {
            bridge.add(distinguish());
        }
        return bridge;
    }

    private String distinguish() {
        if (bridgeNumberGenerator.generate() == DOWN_BRIDGE_NUMBER) {
            return DOWN_BRIDGE_PHRASE;
        }
        return UP_BRIDGE_PHRASE;
    }
}
