package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final int UPWARD_PASSABLE_CASE = 1;
    private final String UPWARD_PASSABLE = "U";
    private final String DOWNWARD_PASSABLE = "D";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    private String getBridgeElement(int bridgeNumber) {
        if (bridgeNumber == UPWARD_PASSABLE_CASE) {
            return UPWARD_PASSABLE;
        }
        return DOWNWARD_PASSABLE;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridgeElements = new ArrayList<>();
        for (int currentSize = 0; currentSize < size; currentSize++) {
            String bridgeElement = getBridgeElement(bridgeNumberGenerator.generate());
            bridgeElements.add(bridgeElement);
        }

        return bridgeElements;
    }
}
