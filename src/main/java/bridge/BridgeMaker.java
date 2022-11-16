package bridge;

import constants.BridgeConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final Map<Integer, String> bridgeDirection;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
        bridgeDirection = Map.of(0, BridgeConstants.DOWN_DIRECTION,
                1, BridgeConstants.UP_DIRECTION);
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        while (size > 0) {
            int direction = bridgeNumberGenerator.generate();
            bridge.add(bridgeDirection.get(direction));
            size--;
        }

        return bridge;
    }
}
