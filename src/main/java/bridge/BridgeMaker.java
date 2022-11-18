package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final int MOVE_DOWN_NUMBER = 0;
    private static final String MOVE_UP = "U";
    private static final String MOVE_DOWN = "D";
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;
    private static final String BRIDGE_SIZE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateBridgeSize(size);
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (bridgeNumberGenerator.generate() == MOVE_DOWN_NUMBER) {
                bridge.add(MOVE_DOWN);
                continue;
            }
            bridge.add(MOVE_UP);
        }
        return bridge;
    }
    private void validateBridgeSize(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
        }
    }
}
