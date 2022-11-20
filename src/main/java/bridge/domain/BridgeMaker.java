package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private static final String UPPER_CELL = "U";
    private static final String DOWN_CELL = "D";
    private static final Integer UPPER_CELL_TO_INT = 1;

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
        for (int brideIndex = 0; brideIndex < size; ++brideIndex) {
            bridge.add(toStringBridge());
        }

        return bridge;
    }

    private String toStringBridge() {
        if (bridgeNumberGenerator.generate() == UPPER_CELL_TO_INT) {
            return UPPER_CELL;
        }
        return DOWN_CELL;
    }
}
