package bridge;

import java.util.LinkedList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final String RANGE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        checkSizeRange(size);
        List<String> bridge = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            BridgeDirection bridgeDirection = BridgeDirection.toBridgeDirection(bridgeNumberGenerator.generate());
            bridge.add(bridgeDirection.getDirection());
        }
        return bridge;
    }

    private void checkSizeRange(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }
}
