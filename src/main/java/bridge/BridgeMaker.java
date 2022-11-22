package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final int UP_SIDE = 0;

    private static final int DOWN_SIDE = 1;

    private static final String UP = "U";

    private static final String DOWN = "D";
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
        for (int i = 0; i < size; i++) {
            if (bridgeNumberGenerator.generate() == DOWN_SIDE) {
                bridge.add(UP);
                continue;
            }
            bridge.add(DOWN);
        }
        return bridge;
    }

    private String toString(int number) {
        return String.valueOf(number);
    }
}
