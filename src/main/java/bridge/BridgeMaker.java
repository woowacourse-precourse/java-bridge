package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final int UP_NUMBER = 1;
    private static final int DOWN_NUMBER = 0;

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
        for (int idx = 0; idx < size; idx++){
            int randNumber = bridgeNumberGenerator.generate();
            addBridge(bridge, randNumber);
        }
        return null;
    }

    private void addBridge(List<String> bridge, int randNumber) {
        if (randNumber == UP_NUMBER)
            bridge.add(UP);
        if (randNumber == DOWN_NUMBER)
            bridge.add(DOWN);
    }
}
