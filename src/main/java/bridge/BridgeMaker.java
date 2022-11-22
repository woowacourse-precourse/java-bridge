package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private final String UP_BRIDGE_BTN = "U";
    private final String DOWN_BRIDGE_BTN = "D";
    private final int WALK_UP_BRIDGE = 1;
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
        for(int i=0; i<size; i++) {
            bridge.add(getUpOrDown());
        }
        return bridge;
    }

    public String getUpOrDown() {
        if(bridgeNumberGenerator.generate() == WALK_UP_BRIDGE) {
            return UP_BRIDGE_BTN;
        }
        return DOWN_BRIDGE_BTN;
    }
}
